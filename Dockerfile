FROM maven:3.8.6-openjdk-18-slim

# Install Firefox, Xvfb, wget, unzip
RUN apt-get update && apt-get install -y \
    firefox-esr xvfb wget unzip \
    && rm -rf /var/lib/apt/lists/*

# Install GeckoDriver
RUN GECKO_VERSION=v0.33.0 && \
    wget -qO /tmp/geckodriver.tar.gz https://github.com/mozilla/geckodriver/releases/download/${GECKO_VERSION}/geckodriver-${GECKO_VERSION}-linux64.tar.gz && \
    tar -xzf /tmp/geckodriver.tar.gz -C /usr/local/bin/ && \
    rm /tmp/geckodriver.tar.gz && chmod +x /usr/local/bin/geckodriver

WORKDIR /app

COPY . .

# Run tests with virtual display
CMD ["bash", "-c", "xvfb-run mvn clean test"]
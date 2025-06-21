FROM maven:3.8.6-openjdk-18-slim

# Install dependencies and utilities
RUN apt-get update && apt-get install -y --no-install-recommends \
    wget \
    gnupg \
    unzip \
    xvfb \
    xauth \
    libgtk-3-0 \
    libxss1 \
    libasound2 \
    libnss3 \
    libx11-xcb1 \
    libxcomposite1 \
    libxcursor1 \
    libxdamage1 \
    libxi6 \
    libxtst6 \
    fonts-liberation \
    libappindicator3-1 \
    libatk-bridge2.0-0 \
    libatk1.0-0 \
    libcups2 \
    libcups2-dev \
    libdbus-glib-1-2 \
    libdrm2 \
    libgbm1 \
    libnspr4 \
    libxrandr2 \
    ca-certificates \
    && rm -rf /var/lib/apt/lists/*

# Add Microsoft GPG key and repo, then install Microsoft Edge
RUN wget -q https://packages.microsoft.com/keys/microsoft.asc -O- | apt-key add - \
    && sh -c 'echo "deb [arch=amd64] https://packages.microsoft.com/repos/edge stable main" > /etc/apt/sources.list.d/microsoft-edge.list' \
    && apt-get update \
    && apt-get install -y microsoft-edge-stable \
    && rm -rf /var/lib/apt/lists/*

# Install matching Edge WebDriver (fetch Edge version dynamically or hardcode if preferred)
# Here, hardcoding to a version; update if needed
ARG EDGE_VERSION=114.0.1823.51
RUN wget -qO /tmp/edgedriver.zip https://msedgedriver.azureedge.net/${EDGE_VERSION}/edgedriver_linux64.zip \
    && unzip /tmp/edgedriver.zip -d /usr/local/bin/ \
    && rm /tmp/edgedriver.zip \
    && chmod +x /usr/local/bin/msedgedriver

WORKDIR /app

COPY . .

ENTRYPOINT ["xvfb-run"]
CMD ["mvn", "clean", "verify"]

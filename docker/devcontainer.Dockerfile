# https://github.com/docker-library/openjdk/issues/505 
FROM eclipse-temurin:8

# Install ant and useful dev tools
RUN apt-get -y update && apt-get install -y ant git curl && rm -rf /var/lib/apt/lists/*

# Create javacard libs directory 
RUN mkdir -p /javacard/libs && chmod -R 777 /javacard

ARG ANT_JAVACARD_RELEASE="v25.11.24.1"
# Download ant-javacard
RUN curl -L -o /javacard/ant-javacard.jar https://github.com/martinpaljak/ant-javacard/releases/download/${ANT_JAVACARD_RELEASE}/ant-javacard.jar

# Clone JavaCard SDKs from martinpaljak's repository
RUN git clone --depth 1 https://github.com/martinpaljak/oracle_javacard_sdks.git /javacard/oracle_javacard_sdks

# Set working directory, default thing of testcontainers
WORKDIR /workspaces

# Keep container running
CMD ["sleep", "infinity"]

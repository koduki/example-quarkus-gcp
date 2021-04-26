FROM ghcr.io/graalvm/graalvm-ce

RUN gu install native-image

RUN curl https://downloads.apache.org/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz | tar zx -C /opt && \
ln -s /opt/apache-maven-3.8.1/bin/mvn /usr/bin/mvn
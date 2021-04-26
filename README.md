# example-gcp-graal2 project

This project is an example for Qurkus + GCP Library + GraalVM native-image.
Thank you for greate libary, GoogleCloudPlatform team.
https://github.com/GoogleCloudPlatform/google-cloud-graalvm-support

ref:
- [Quarkus + GraalVM (native-image)でGCP系ライブラリを利用する](https://zenn.dev/koduki/articles/7d02c433121fb3)

## Build Builder

```bash
$ cd builder
$ gcloud builds submit 
```

## Build on Local


### JVM

```bash
$ GOOGLE_APPLICATION_CREDENTIALS=~/.seacret/key.json ./target/example-gcp-graal2-1.0.0-SNAPSHOT-runner
```

### native-image

```bash
$ mvn clean package -P native
#or
$ ./mvnw package -Pnative -Dquarkus.native.container-build=true
```

## Build & Deploy

```bash
$ gclo
```

## Connectivity Test

```
$ curl http://localhost:8080/hello/say
Project: xxx, key: 5760334488928256                                             
$ curl http://localhost:8080/hello/listen
title: test - Wed Apr 28 00:49:50 PDT 2021, count: 11
```
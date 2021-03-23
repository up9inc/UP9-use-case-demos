FROM weaveworksdemos/msd-java:jre-latest

WORKDIR /usr/src/app
COPY *.jar ./app.jar

RUN	chown -R ${SERVICE_USER}:${SERVICE_GROUP} ./app.jar

USER root
RUN apk --no-cache add curl
RUN curl -L "https://repository.sonatype.org/service/local/artifact/maven/redirect?r=central-proxy&g=com.rookout&a=rook&v=LATEST" -o rook.jar

USER ${SERVICE_USER}

ARG BUILD_DATE
ARG BUILD_VERSION
ARG COMMIT

LABEL org.label-schema.vendor="Weaveworks" \
  org.label-schema.build-date="${BUILD_DATE}" \
  org.label-schema.version="${BUILD_VERSION}" \
  org.label-schema.name="Socks Shop: Shipping" \
  org.label-schema.description="REST API for Shipping service" \
  org.label-schema.url="https://github.com/microservices-demo/shipping" \
  org.label-schema.vcs-url="github.com:microservices-demo/shipping.git" \
  org.label-schema.vcs-ref="${COMMIT}" \
  org.label-schema.schema-version="1.0"

ENV ROOKOUT_TOKEN=ac67ad5213d4263fc3c1971008786a9aab3534ff547d0409a6c5217a33b5a879
ENV ROOKOUT_LABELS=env:dev,app:sockapp,service:shipping
ENV ROOKOUT_REMOTE_ORIGIN=https://github.com/up9inc/UP9-use-case-demos
ENV ROOKOUT_COMMIT=master

ENTRYPOINT ["/usr/local/bin/java.sh","-javaagent:rook.jar","-jar","./app.jar", "--port=80"]


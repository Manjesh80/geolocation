FROM nginx:latest
ENV CONSUL_URL consul:8500
RUN apt-get update && apt-get install -y unzip wget
RUN mkdir -p /opt/ganesh/consul-template
WORKDIR /opt/ganesh/consul-template
RUN wget https://releases.hashicorp.com/consul-template/0.16.0/consul-template_0.16.0_linux_amd64.zip \
    && unzip consul-template_0.16.0_linux_amd64.zip
ADD default.ctmpl /opt/ganesh/consul-template/
ADD startup.sh /opt/ganesh/consul-template/
RUN chmod +777 /opt/ganesh/consul-template/startup.sh
RUN rm /etc/nginx/conf.d/default.conf
EXPOSE 80
ENTRYPOINT ["/opt/ganesh/consul-template/startup.sh"]
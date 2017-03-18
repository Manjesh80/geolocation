#!/bin/bash
echo '****************** Jai Ganesh staring script *****************'
service nginx start && /opt/ganesh/consul-template/consul-template -consul=$CONSUL_URL -template="default.ctmpl:/etc/nginx/conf.d/default.conf:service nginx reload"
echo '****************** Jai Ganesh staring script done *****************'

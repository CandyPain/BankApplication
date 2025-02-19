cd /mnt/mqm
mkdir -p MQServer/certs
cd MQServer/certs
runmqakm -keydb -create -db key.p12 -pw k3ypassw0rd -type pkcs12 -expire 1000 -stash
runmqakm -cert -create -db key.p12 -label ibmwebspheremqqm1 -dn "cn=qm,o=ibm,c=uk" -size 2048 -default_cert yes -stashed
runmqakm -cert -extract -db key.p12 -stashed -label ibmwebspheremqqm1 -target QM1.cert

cd ../..
mkdir -p MQClient/certs
cd MQClient/certs
runmqakm -keydb -create -db client_key.p12 -pw tru5tpassw0rd -type pkcs12 -expire 1000
runmqakm -cert -add -label QM1.cert -db client_key.p12 -type pkcs12 -pw tru5tpassw0rd -trust enable -file ../../MQServer/certs/QM1.cert
#!/bin/bash

# -td           : define um diretório de saída
# -pkgPrefix    : define o nome do pacote como prefixo para o módulo
# -f<tipo>      : define o tipo de código a ser gerado (não afeta struct)
#            all: cliente + servidor
#         client: somente cliente
#         server: somente servidor

#somente cliente para o módulo de serviço
idlj -td src/main/java -pkgPrefix service ag.ifpb.rmi.iiop.idl -fclient Hello.idl

#somente server para o módulo de serviço
idlj -td src/main/java -pkgPrefix service ag.ifpb.rmi.iiop.idl -fserver Hello.idl
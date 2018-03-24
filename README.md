# Dashboard_e2a

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5a963e9cc71c4f0c951250172abd6d15)](https://www.codacy.com/app/PablooD9/InciDashboard_e2a?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=Arquisoft/InciDashboard_e2a&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/Arquisoft/InciDashboard_e2a.svg?branch=master)](https://travis-ci.org/Arquisoft/InciDashboard_e2a)
[![codecov](https://codecov.io/gh/Arquisoft/InciDashboard_e2a/branch/master/graph/badge.svg)](https://codecov.io/gh/Arquisoft/InciDashboard_e2a)

Dashboard - e2a

# Autores

* César Camblor García (@UO251281)

* Pablo Díaz Rancaño (@UO251017)

* Fernando De la Torre Cueva (@UO245182)

* Pablo Álvarez Álvarez (@UO251561)

## Introducción al repositorio

Este repositorio pertenece a la parte *Dashboard* del grupo de trabajo **E2a**,
encargada de mostrar, en un panel de control, las incidencias enviadas por agentes y asignadas a los operarios.

## Cómo ejecutar el proyecto

### Base de datos HSQLDB (versión 2.4.0)
La base de datos a utilizar es HSQLDB (**Se puede descargar [aquí](https://sourceforge.net/projects/hsqldb/files/latest/download?source=files)**). A continuación, simplemente se ejecuta el fichero bin/startup.bat.

### Apache Zookeeper y Apache Kafka
Para poder ejecutar Apache Zookeeper y Apache Kafka, puedes descargar la carpeta desde [aquí](https://unioviedo-my.sharepoint.com/:u:/g/personal/uo251017_uniovi_es/EQPNYDwHknpCtZI1U1wK7QUBIEoZVywWTvmwFfO3upoA-A?e=kh1lYE).

### Abrir Apache Zookeeper
Una vez descargado el zip del paso anterior, abre la línea de comandos en la carpeta raíz de la carpeta *kafka_2.11-0.10.2.0*.

Para Windows, ejecuta estos dos comandos en orden (el primero abre Zookeeper. El segundo, Apache Kafka):
```bash
C:\...\kafka_2.11-0.10.2.0>bin\windows\zookeeper-server-start.bat config\zookeeper.properties
```
```bash
C:\...\kafka_2.11-0.10.2.0>bin\windows\kafka-server-start.bat config\server.properties
```

Para Linux:
```bash
C:\...\kafka_2.11-0.10.2.0>bin/zookeeper-server-start.sh config/zookeeper.properties
```
```bash
C:\...\kafka_2.11-0.10.2.0>bin/kafka-server-start.sh config/server.properties
```

Por último, sitúate en la carpeta raíz del proyecto del repositorio, y ejecuta el siguiente comando:
```bash
C:\...\proyecto_dashboard>mvn spring-boot:run
```

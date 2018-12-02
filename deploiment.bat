set currentpath=%~dp0
set springbootrun=mvn spring-boot:run

cd %currentpath%\eurekaServer
start %springbootrun%

cd %currentpath%\microServiceImage
start %springbootrun%

cd %currentpath%\microServiceProduct
start %springbootrun%

cd %currentpath%\mainService
start %springbootrun%

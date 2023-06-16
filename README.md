
Bu proje klasöründe customer, realestate, realestateagent ve shared olmak üzere;
Entitylere ait 3 ve response için 1 olmak üzere 4 klasör bulunmaktadır.

Entitylere ait her bir klasör altında o objeye ait controller, repository, service, service implementation sınıflarına ek olarak
request ve response dtoları ve mapper sınıfı vardır.

Bu projede PostgreSql kullanılmıştır. Projenin çalışabilmesi için lokal bilgisayarınızda PostgreSQL kurulu olmalıdır ve 5432 portundan dinlemelidir.

Senaryonuzu test etmek için aşağıdaki sorguları Postman'de çalıştırmanız yeterli olacaktır. 

POST metodu seçtikten sonra yeni bir emlak işletmesi eklemek için:

Path: http://localhost:8081/real-estate-agent

Aşağıdaki Json formatındaki verileri ayrı ayrı yazarak çalıştırın.

{
    "agentName" : "Faden Emlak",
    "authorizedPerson" : "Mehmet Çelebi",
    "address" : "Gölbaşı/Ankara",
    "phone" : "1234567890"

}

{
    "agentName" : "Borsem Emlak",
    "authorizedPerson" : "Yücel Kara",
    "address" : "Çankaya/Ankara",
    "phone" : "5555555555"

}

POST metodu seçtikten sonra yeni bir müşteri eklemek için:

Path: http://localhost:8081/customer

{
    "firstName" : "Betül",
    "lastName" : "Islam",
    "address" : "İlkbahar Mah. GP2 Çankaya/Ankara",
    "email" : "bislamm@gmail.com",
    "realEstateAgentId" : [1]
}

{
    "firstName" : "Ziaul",
    "lastName" : "Islam",
    "address" : "İlkbahar Mah. GP2 Çankaya/Ankara",
    "email" : "ziaislammmm@gmail.com",
    "realEstateAgentId" : [2]
}

{
    "firstName" : "Elif",
    "lastName" : "Tultay Nurdağ",
    "address" : "İlkbahar Mah. MVK Çankaya/Ankara",
    "email" : "etultay@gmail.com",
    "realEstateAgentId" : [1,2]
}

{
    "firstName" : "Muhammed Nur",
    "lastName" : "Nurdağ",
    "address" : "İlkbahar Mah. MVK Çankaya/Ankara",
    "email" : "mnurdag@gmail.com",
    "realEstateAgentId" : []
}

POST metodu seçtikten sonra müşteriye ait yeni bir emlak eklemek için:

forSale: true/satılık, false/kiralık olduğunu temsil etmektedir.

{
    "city" : "Kayseri",
    "district" : "Talas",
    "type" : "Daire",
    "mSquare" : 155,
    "roomCount" : 5,
    "flatFloor" : 1,
    "buildingFloorCount" : 14,
    "forSale" : false,
    "customerId": 1
}

{
    "city" : "Ankara",
    "district" : "Çankaya",
    "type" : "Daire",
    "mSquare" : 175,
    "roomCount" : 4,
    "flatFloor" : 1,
    "buildingFloorCount" : 21,
    "forSale" : false,
    "customerId": 3
}

{
    "city" : "Ankara",
    "district" : "Gölbaşı",
    "type" : "Villa",
    "mSquare" : 200,
    "roomCount" : 6,
    "flatFloor" : 0,
    "buildingFloorCount" : 3,
    "forSale" : true,
    "customerId": 2
}

{
    "city" : "Ankara",
    "district" : "Gölbaşı",
    "type" : "Daire",
    "mSquare" : 130,
    "roomCount" : 2,
    "flatFloor" : 3,
    "buildingFloorCount" : 6,
    "forSale" : false,
    "customerId": 4
}

GET metodu seçtikten sonra seçilen özelliklere sahip emlakları listelemek için

http://localhost:8081/real-estate?city=Kayseri&district=Talas&type=Daire

http://localhost:8081/real-estate?city=Kayseri&district=Talas&type=Villa

http://localhost:8081/real-estate?city=Ankara&district=Gölbaşı

http://localhost:8081/real-estate?city=Ankara&type=Daire

http://localhost:8081/real-estate?city=Ankara&district=Çankaya&type=Daire&mSquare=175&flatFloor=1&forSale=false

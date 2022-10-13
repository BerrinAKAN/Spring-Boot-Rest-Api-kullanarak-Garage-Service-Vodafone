# Spring Boot Rest Api kullanarak Garage-Service-Vodafone

## Garage
</br></br>

*In this problem, you have a garage that can be parked up to 10 slots (you can consider each slot is 1 unit range) at any 
given point in time. You should create an automated ticketing system that allows your customers to use your garage 
without human intervention. When a car enters your garage, you give a unique ticket issued to the driver. The ticket 
issuing process includes us documenting the plate and the colour of the car and allocating an available slots to the car 
before actually handing over a ticket to the driver. When a vehicle holds number of slots with its own width, you have to 
leave 1 unit slot to next one. The customer should be allocated slot(s) which is nearest to the entry. At the exit the 
customer returns the ticket which then marks slot(s) they were using as being available.*


 *Database kullanmadan in memory çözüm kullanıldı.Exception handling, Unit test ve thread safe dikkat edilerek proje geliştirildi.*
 
 *Aşağıda Garage modelim için json verilerim bulunuyor. GarageController sınıfımda Rest api uyguladım. Postman ekran görüntüsü aşağıdadır.*
   </br>
![image](https://user-images.githubusercontent.com/61009480/195713218-d3965cf2-182a-4c69-a096-bba5d9b24c5e.png)

![image](https://user-images.githubusercontent.com/61009480/195714115-17b02fb7-03f0-49ec-8ea3-0aacb3f38c7e.png)
</br>
![image](https://user-images.githubusercontent.com/61009480/195714293-eeba25e6-8ca1-4dec-90fd-40f906df672c.png)
</br>
*Aşağıda Unit testimde garage 9 slot dolu ve her araç arasında 1 boşluk olduğu için garage is full exception'ı döndürdüm.*
</br>
![image](https://user-images.githubusercontent.com/61009480/195714420-fcb3e8a7-c814-466f-92e0-e756aa0a2349.png)


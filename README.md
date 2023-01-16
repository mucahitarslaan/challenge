# About Project

This project has basic relation between Company Entity and Employee Entity. Also, this project includes CRUD operations.



## Java Documentation for Project

Description for Classes and Interfaces are given below.

[All Classes and Interfaces in Project](https://htmlpreview.github.io/?https://github.com/mucahitarslaan/challenge/blob/main/enoca-challange-javadoc/allclasses-index.html)

- [Controller Package](https://htmlpreview.github.io/?https://github.com/mucahitarslaan/challenge/blob/main/enoca-challange-javadoc/allclasses-index.html)

    - [CompanyController](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/controller/CompanyController.html)
    
    - [EmployeeController](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/controller/EmployeeController.html)

- [Service Package](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/index.html)

    - [ServiceImpl](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/service/impl/package-summary.html)

    - [ServiceAbstracts](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/service/abstracts/package-summary.html)

- [DTO Package](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/index.html)

    - [MapperDTO](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/dto/mapper/package-summary.html)

    - [RequestDTO](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/dto/request/package-summary.html)

    - [ResponseDTO](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/dto/response/package-summary.html)

- [Repository Package](https://htmlpreview.github.io/?https://github.com/mucahitarslaan/challenge/blob/main/enoca-challange-javadoc/allclasses-index.html)

    - [CompanyRepository](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/repository/CompanyRepository.html)

    - [EmployeeRepository](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/repository/EmployeeRepository.html)

- [Model Package](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/model/package-summary.html)

    - [CompanyEntity](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/model/Company.html)

    - [EmployeeEntity](https://htmlpreview.github.io/?https://raw.githubusercontent.com/mucahitarslaan/challenge/main/enoca-challange-javadoc/com/mucahitarslan/challenge/model/Employee.html)

  

## Company Endpoints Details

#### 

```http
POST /api/v1/companies  
  
curl -d '{"companyName":"Enoca", "address":"Flora Residans Vedat Günyol Caddesi Defne Sokak No:1 Kat:25 Ofis:2501,2502",
"phoneNumber":"+90 216 266 24 05","email":"contact@enoca.com"}' 
-H "Content-Type: application/json" -X POST http://localhost:8099/api/v1/companies
```

```http
GET /api/v1/companies

curl -d "Content-Type: application/json" -X GET http://localhost:8099/api/v1/companies
```

```http
GET /api/v1/companies/{id}

curl -d "Content-Type: application/json" -X GET http://localhost:8099/api/v1/companies/1
```

```http
PUT /api/v1/companies/{id}

curl -d '{"companyName":"Enoca BİLGİ TEKNOLOJİLERİ VE DANIŞMANLIK LİMİTED ŞİRKETİ"}' 
-H "Content-Type: application/json" -X PUT http://localhost:8099/api/v1/companies/1
```

```http
DELETE /api/v1/companies/{id}

curl -d "Content-Type: application/json" -X DELETE http://localhost:8099/api/v1/companies/1
```


## Employee Endpoints Details

#### 

```http
POST /api/v1/employees  
  
curl -d '{"firstName":"Mücahit", "lastName":"Arslan","address":"Kocaeli",
"phoneNumber":"+90 555 555 55 55", "email":"mucahitarslaan@gmail.com","companyId":1}' 
-H "Content-Type: application/json" -X POST http://localhost:8099/api/v1/employees
```

```http
GET /api/v1/employees

curl -d "Content-Type: application/json" -X GET http://localhost:8099/api/v1/employees
  
```

```http
GET /api/v1/employees/{id}

curl -d "Content-Type: application/json" -X GET http://localhost:8099/api/v1/employees/1
  
```

```http
PUT /api/v1/employees/{id}

curl -d '{"address":"Gebze/KOCAELİ","phoneNumber":"+90 111 111 11 11"}' 
-H "Content-Type: application/json" -X PUT http://localhost:8099/api/v1/employees/1
```

```http
DELETE /api/v1/employees/{id}

curl -d "Content-Type: application/json" -X DELETE http://localhost:8099/api/v1/employees/1
```

  
  
## Working On Application - Images

-  If you send a post and put request for a Company and then send a post and put request for an Employee, the Company and Employee tables will be as follows.

                                                    Company Table
![Logo](https://github.com/mucahitarslaan/challenge/blob/main/company-table-image.png?raw=true)

                                                      Employee Table

![Logo](https://github.com/mucahitarslaan/challenge/blob/main/employee-table-image.png?raw=true)
  

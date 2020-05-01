# Spring OpenAPI 3.0 Örneği

Spring Boot 2 web servislerinin otomatik olarak dokümantasyonunu oluşturmak için iki şey kullanıyoruz.

1. Springdoc OpenAPI kütüphanesi
2. Redoc kütüphanesi

Öncelikle `pom.xml` dosyasına springdoc bağımlılığını ekliyoruz:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.3.7</version>
</dependency>
```

Bu kütüphane controller'larımızı tarıyarak bize hem openapi url'sini hazırlıyor (`/v3/api-docs`)
hem de swagger uygulaması arayüzünü veriyor (`/swagger-ui.html`)

Swagger arayüzü, openapi url'sini kullanarak, servisleri canlı olarak deneyebileceğimiz interaktif
bir ortam veriyor. Swagger arayüzü url'sini değiştirmek için `application.properties` dosyasına aşağıdaki
property'yi ekleyebiliriz:

```properties
springdoc.swagger-ui.path=/swagger
```

Uygulamaya farklı dokümantasyon bilgileri eklemek için;

```java
@OpenAPIDefinition(
        info = @Info(
                title = "Fruits API",
                version = "0.1.0",
                description = "Demo Documentation",
                contact = @Contact(
                        name = "Fruits API Support",
                        url = "http://fruitsapi.com/contact",
                        email = "techsupport@fruitsapi.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        tags = {
                @Tag(name = "fruits")
        }
)
```

şeklinde annotation'lar kullanabiliriz.

Swagger arayüzü daha çok geliştirme sırasında kullanılırken Redoc kütüphanesi canlı ortamda da
kullanılabilecek statik bir dokümantasyon hazırlamak için kullanılabilir.

Bunun için tek yapmamız gereken aşağıdaki html'i static dizini altına atmak:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Frutis Documentation</title>
    <!-- needed for adaptive design -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,700|Roboto:300,400,700" rel="stylesheet">

    <!--
    ReDoc doesn't change outer page styles
    -->
    <style>
        body {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<redoc spec-url='/v3/api-docs'></redoc>
<script src="https://cdn.jsdelivr.net/npm/redoc@next/bundles/redoc.standalone.js"> </script>
</body>
</html>
```
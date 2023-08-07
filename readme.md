# Merchant Locations API Client
[![](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/Mastercard/loyalty-user-management-reference/blob/master/LICENSE)

## Table of Contents

- [Overview](#overview)
    * [Compatibility](#compatibility)
    * [References](#references)
    * [Tutorial](#tutorial)
    * [Frameworks](#frameworks)
- [Setup](#setup)
    * [Prerequisites](#prerequisites)
    * [Application Configuration](#configuration)
    * [Build and Execute](#build-and-execute)
    * [Reference Application Usage](#client-application-usage)
    * [Integrating with OpenAPI Generator](#integrating-with-openapi-generator)
- [Use Cases](#use-cases)
    * [Parameters](#parameters)
    * [Countries](#countries)
    * [Country SubDivisions](#countrysubdivisions)
    * [Categories](#categories)
    * [Merchant Search](#merchants)
- [API Reference](#api-reference)
- [Authentication](#authentication)
    * [Mastercard's OAuth Library](#oauth-library)
- [Glossary](#glossary)
- [Support](#support)
- [License](#license)

## Overview <a name="overview"/>
This project showcases the use case of retrieving merchant locations and related information using the Merchants Locations API [here](https://developer.mastercard.com/locations/documentation/)

### Compatibility <a name="compatibility"></a>
 * [Java 11](https://www.oracle.com/java/technologies/downloads/#java11) or later
 
### References <a name="references"></a>
* [Mastercard’s OAuth Signer library](https://github.com/Mastercard/oauth1-signer-java)
* [Using OAuth 1.0a to Access Mastercard APIs](https://developer.mastercard.com/platform/documentation/using-oauth-1a-to-access-mastercard-apis/)

### Tutorial <a name="tutorial"></a>
A tutorial can be found [here](https://developer.mastercard.com/locations/documentation/tutorial/) for setting up and using this service.

## Frameworks <a name="frameworks"></a>
- OpenAPI Generator
- [Java 11+](https://www.oracle.com/java/technologies/downloads/#java11)
- [Maven](https://maven.apache.org/download.cgi)

## Setup <a name="setup"></a>

### Prerequisites <a name="prerequisites"></a>

* [Mastercard Developers Account](https://developer.mastercard.com/dashboard)
* A text editor or IDE
* [Java 11+](https://www.oracle.com/java/technologies/downloads/#java11)
* [Apache Maven 3.3+](https://maven.apache.org/download.cgi)
* Set up the `JAVA_HOME` environment variable to match the location of your Java installation.

### Application Configuration <a name="configuration"> </a>
1. Create an account at [Mastercard Developers](https://developer.mastercard.com).
2. Copy the [Merchants Locations API Spec](https://developer.mastercard.com/locations/documentation/api-reference/) (`merchants-locations-api-spec.yaml`) to `/src/main/resources`.  
3. Create a new project and add the `Merchants Locations` API to your project.
    * A zip file will be downloaded automatically with your keys.
4. Take note of the given **consumer key, keyalias, and keystore password** given upon the project creation.
5. Copy the downloaded `.p12` file to `/src/main/resources`.
6. Update the properties found in `src/main/java/com/mastercard/locations/merchants/ApiService.java`.

```java
    private static final String API_BASE_PATH = "https://sandbox.api.mastercard.com/locations/merchants";

    //Below properties will be required for authentication of API calls.
    private static final String CONSUMER_KEY = "Your consumer key"; // This refers to your consumer key. Copy it from "Keys" section on your project page in [Mastercard Developers](https://developer.mastercard.com/dashboard)
    private static final String SIGNING_KEY_ALIAS = "your key alias"; // This is the default value of key alias. If it is modified, use the updated one from keys section in [Mastercard Developers](https://developer.mastercard.com/dashboard).
    private static final String SIGNING_KEY_FILE_PATH = "path to your.p12 private key file"; // This refers to .p12 file found in the signing key. Please place .p12 file at src\main\resources in the project folder and add classpath for .p12 file.
    private static final String SIGNING_KEY_PASSWORD = "your password"; // This is the default value of key alias. If it is modified, use the updated one from keys section in [Mastercard Developers](https://developer.mastercard.com/dashboard).

```

7. Run `mvn clean generate-sources` from the root of the project directory.
    * When compile is run, the [OpenAPI Generator plugin](#integrating-with-openapi-generator) will generate the sources for connecting to the Merchants Locations API.
8. run `mvn compile exec:java` to run the project.


### Integrating with OpenAPI Generator <a name="integrating-with-openapi-generator"></a>
[OpenAPI Generator](https://github.com/OpenAPITools/openapi-generator) generates API client libraries from [OpenAPI Specs](https://github.com/OAI/OpenAPI-Specification). 
It provides generators and library templates for supporting multiple languages and frameworks.

See also:
* [OpenAPI Generator (maven Plugin)](https://mvnrepository.com/artifact/org.openapitools/openapi-generator-maven-plugin)
* [OpenAPI Generator (executable)](https://mvnrepository.com/artifact/org.openapitools/openapi-generator-cli)
* [CONFIG OPTIONS for java](https://github.com/OpenAPITools/openapi-generator/blob/master/docs/generators/java.md)

#### OpenAPI Generator Plugin Configuration
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.openapitools</groupId>
            <artifactId>openapi-generator-maven-plugin</artifactId>
            <version>4.3.0</version>
            <executions>
                <execution>
                    <goals>
                        <goal>generate</goal>
                    </goals>
                    <configuration>
                        <inputSpec>${project.basedir}/src/main/resources/merchants-locations-api-spec.yaml</inputSpec>
                        <generatorName>java</generatorName>
                        <library>okhttp-gson</library>
                        <generateApiTests>false</generateApiTests>
                        <generateModelTests>false</generateModelTests>
                        <configOptions>
                            <sourceFolder>src/gen/java/main</sourceFolder>
                            <dateLibrary>Java11</dateLibrary>
                        </configOptions>
                    </configuration>
                </execution>
            </executions>
            </plugin>
    </plugins>
</build>
```

## Use Cases <a name="use-cases"></a>

#### Parameters <a name="parameters"></a>
These are the parameters used for the Merchants Locations API. All parameters are optional.

| Name      | Type      | Default Value      | Purpose       |
|-----------|-----------|--------------------|---------------|
| offset    | int       | 0                  | For Pagination; offset is used to offset the start of the list.        |
| limit     | int       | 25                 | For Pagination; limit is used to limit the number of entities returned |
| distance  | int       | 5                 | The length of distance from the centroid point  |
| distance_unit     | string       | MILE                 | Unit of measurement for calculating the radius search |

### Countries <a name="countries"></a>

| URL       | Method        | Parameters        | Request Model | Response model|
|-----------|---------------|-------------------|---------------|---------------|
|/countries | GET           | -                 | -             |-              |

### Country SubDivisions <a name="countrysubdivisions"></a>

| URL       | Method        | Parameters        | Request Model | Response model|
|-----------|---------------|-------------------|---------------|---------------|
|/country-subdivisions      | GET               |country_code   | -             |

### Categories <a name="categories"></a>

| URL       | Method        | Parameters        | Request Model | Response model|
|-----------|---------------|-------------------|---------------|---------------|
|/categories| GET           |-                  | -             |-              |

### Merchant Search <a name="merchants"></a>
> Get a paginated list of merchants that fit the search criteria. 

| URL       | Method        | Parameters        | Request Model | Response model|
|-----------|---------------|-------------------|---------------|---------------|
|/searches| POST     | offset, limit, distance, distance_unit     | MerchantSearch    | Merchants |



## API Reference <a name="api-reference"></a>

See the [API Reference](https://developer.mastercard.com/locations/documentation/api-reference/) page in the documentation. 

| API Endpoint                  | Description                                                       |
| ----------------------------- | ----------------------------------------------------------------- |
| [Merchants Search](https://developer.mastercard.com/locations/documentation/api-reference/#api)                 | Retrieve merchant detail for a given geo location |
| [Get Countries](https://developer.mastercard.com/locations/documentation/api-reference/#api)            | List all countries              |
| [Get Country Subdivisions](https://developer.mastercard.com/locations/documentation/api-reference/#api)   | List of country subdivisions per country                      |
| [Get Categories](https://developer.mastercard.com/locations/documentation/api-reference/#api)   | List of country subdivisions per country                      |

## Authentication <a name="authentication"></a>

### Mastercard oauth1 Signer Library <a name="oauth-library"></a>
This dependency is required to properly call the API.
```xml
<dependency>
    <groupId>com.mastercard.developer</groupId>
    <artifactId>oauth1-signer</artifactId>
    <version>1.2.3</version>
</dependency>
```
[Link to the oauth1 library's Github](https://github.com/Mastercard/oauth1-signer-java)

[Looking for other languages?](https://github.com/Mastercard?q=oauth&type=&language=)

See the code used in this application to utilize the library.

``` Java
        ApiClient client = new ApiClient();
        client.setBasePath(API_BASE_PATH);
        client.setDebugging(true);

        PrivateKey signingKey = AuthenticationUtils.loadSigningKey(SIGNING_KEY_FILE_PATH, SIGNING_KEY_ALIAS, SIGNING_KEY_PASSWORD);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger::info);
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);
        client.setHttpClient(
                client.getHttpClient()
                        .newBuilder()
                        .addInterceptor(new OkHttpOAuth1Interceptor(CONSUMER_KEY, signingKey))
                        .addInterceptor(loggingInterceptor)
                        .build()
        );
}
```

## Support <a name="support"></a>
If you would like further information, please send an email to apisupport@mastercard.com

## License <a name="license"></a>
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

## License
[Apache 2 License](https://apache.org/licenses/LICENSE-2.0)

**Copyright © 1994-2020, All Right Reserved by Mastercard.**
<h1>
Patient App (Spring Security)</h1>

<br>
Spring Security types in this project : <br>
<h6>- InMemoryAuthentication</h6>
<h6>- JDBC Authentication </h6>
<h6>- UserDetailsService Authentication </h6>
----------------------------------------------------------------------------------------------------------------------
<br>

## 1) InMemoryAuthentication

<h4>Login page</h4>

<img src="caps/1.PNG">

<br>


<h4>SecurityConfig.java</h4>

<img src="caps/SecConfig.PNG">

<br>
<h4>SecurityController.java</h4>

<img src="caps/SecController.PNG">

<br>

<h4>Login.html</h4>

<img src="caps/loginHtml.PNG">

<br>
<h4>notAuthorized page</h4>

<img src="caps/notAuthorized.PNG">

<br>
<h4>notAuthorized.html</h4>

<img src="caps/notAuthorized.html.PNG">

<hr>

## 2) JDBC Authentication


<h4>SecurityConfigJDBC.java</h4>

<img src="caps/jdbcConfig.png">

<br>

<h4>application.properties</h4>


<img src="caps/prop.png">

<br>

Pour créer (users and authorities) dans notre base de données nous allons créer un fichier "schema.sql"

<h4>schema.sql</h4>

<img src="caps/schemaSql.png">

<br>

Création des utilisateurs et définir les roles

<img src="caps/commandLine.png">

<br>
Nous allons utiliser un controlleur pour la gestion des paths de "login" et "notAuthorized"
<h4>SecurityController.java</h4>

<img src="caps/secController2.PNG" alt="">

<br>
<h4>Login.html</h4>

<img src="caps/loginHtml.PNG" alt="">

<br>
<h4>notAuthorized page</h4>

<img src="caps/notAuthorized.PNG">

<br>
Lorsqu'on demarre l'application nous avons la page "login"
<h4>1- Login page</h4>

<img src="caps/1.PNG" alt="">

<br>

## 3) UserDetailsService Authentication

<br>
Pour UserDetailsService Authentication nous devrons ajouter les packages: "entities, repositories et services"

<img src="caps/packages.png">

<br>

Pour AppUser:

<h4>AppUser.java</h4>

<img src="caps/appUser.png">

<br>

<h4>AppUserRepository.java</h4>

<img src="caps/appUserRep.png">


<br>

Pour AppRole:

<h4>AppRole.java</h4>

<img src="caps/appRole.png">

<br>

<h4>AppRoleRepository.java</h4>

<img src="caps/appRoleRep.png">

<br>

Pour les services:

<h4>AccountService.java</h4>

<img src="caps/accService.png">

<br>

L'implementation des services :

<img src="caps/impl1.png">

<img src="caps/impl2.png">


<br>

<h4>UserDetailsServiceImpl.java</h4>

<img src="caps/userImpl.png">

<br>

Pour Security Config nous allons utiliser passwordEncoder et SecurityFilterChain et l'injection de userDetailsServiceImpl de type UserDetailsServiceImpl:

<h4>SecurityConfigUser.java</h4>

<img src="caps/SecConfigUser.png">

<br>

Définir les roles ou les autorisations:
<h4>PatientController.java</h4>

<img src="caps/patientController.png">

<br>

Test:

<h4>CommandLineRunnerUserDetails</h4>

<img src="caps/commandLineUser.png">

<br>

<h4>SecurityRestController.java</h4>

<img src="caps/secRest.png">

<br>

Message d'erreur pour les tentatives d'authentification échouées:

<h4>login.html</h4>

<img src="caps/errorMsg.png">

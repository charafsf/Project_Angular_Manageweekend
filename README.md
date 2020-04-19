# Présentation du projet 

- Gérer les envies d'un utilisateur lambda, pour pratiquer les sports de son choix en fonction de la météo et des disponibilités de cet utilisateur et les conditions prérequis pour faire chaque sport. Pou cela on choisit de commencer par la partie de conception sur laquelle on a pris énormément de temps afin d'être sur de nos choix conceptuelles et au niveau de l'architecture qu'on a choisie . 

# Procédure d'installation du projet


# Partie Backend : 
1. Utilisation de l'api Rest 
2. Exposition de l api a l'aide d'un swagger  

# Partie Frontend : 
1. Utilisation du standard Angular matériel 
2. Utilisation de l'outil nginx pour le deployement de la partie frontend

# Partie Docker : 
On peut déployer notre projet en une seule command grâce à Docker.
Il suffit juste de lancer la commande `docker-compose up -d --build` au même niveau que le fichier docker-compose pour déployer toutes les briques de l'application dans des conteneurs docker (Base de données, backend , frontend).

## Explication du precossus de deploiement:
À l'aide du fichier docker compose on définit notre logique de déploiement.
la difficulté rencontrée pour le déploiement de toute l'architecture était le fait que notre conteneur spring-boot se lance plus rapidement que les conteneurs de la base de données ce qui produit un échec de build.
Après plusieurs recherches on a essayé d'utiliser le mot-clé depends_on afin  de préciser que le backend a besoin de la base de données, mais ce mot n'était pas suffisant car il permet de lancer la base de données avant le backend mais après cela le backend se lance directement dans un autre thread qui finit par un build crash.
La solution trouvée dans docker documentation est l'utilisation du mot clé command 
[Docker documentation](https://docs.docker.com/compose/startup-order/ "Docker documentation")
et un script pour attendre que la base de données  soit prête afin d'ensuite lancer le conteneur du backend.
pour cela on a créé un projet simple java **mysql_connection** qui attend notre base de données.



# Problémes Rencontrés 

1. Une grande charge de travail , dans un temps réduit. 
2. Le faite de commencer par le backend, a un peu freiner notre avancement 
suite a des detections de disfonctionnement au niveau de notre architecture conceptuelle .

# Syntéhse et objectifs atteints
- Lors de la réalisation de ce projet, on a était plusieurs fois confrontés à des problèmes techniques (en parlant de technologie Spring Boot ou Angular ou Docker) ou des problèmes conceptuels (Base de données, annotations JPA), mais avec du travail on a réussit à surmonter ses problèmes tout en montant en compétentes concernant ces nouvelles technologies.

- On s'est fixé des objectifs au début du projet mais malheureusement on n'a pas pu  tous les atteindre, le faite de travailler sur plusieurs projets en même temps pour des matiéres différentes nous a mis en retard sur la date du rendu . 

# Definition of use as an automaton
![alt Diagram_TAA](./resources/images/Diagram_TAA.png)

#Api key for maps 
AIzaSyBbtC93KXW2GX_GYt_W6I4t44FJNXtmTbE

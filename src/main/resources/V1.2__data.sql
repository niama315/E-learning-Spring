-- INSERTAR USUARIOS
INSERT INTO user (username, password, nombre, apellido, email, fecha_registro, imgurl) VALUES
('edominguez', '$2a$12$XMQz.p74PYh8JEqkH4TBGORc06E3K3Fbr8Ix4cuu0oqnZq.bxUjBq', 'Edwin', 'Dominguez',
 'edwindominguez@hotmail.com', '2019-09-10', 'https://i.imgur.com/T0n0PH9.jpg'),
('demo', '$2a$11$.NNQgUXukpCuvB5nG.5XGO/NFOESgfPSqETlg5Pj2paBYmStZiucO', 'demo', 'test', 'demo@demo.com', '2019-09-10', 'https://i.imgur.com/k4k1fOM.png');
-- INSERTAR ROLES
INSERT INTO auth_user_group (username, auth_group) VALUES('edominguez', 'USER');
INSERT INTO auth_user_group (username, auth_group) VALUES('edominguez', 'ADMIN');
INSERT INTO auth_user_group (username, auth_group) VALUES('demo', 'USER');
-- INSERTAR PROFESORES
INSERT INTO profesor (nombre, apellido, correo, descripcion, detalle, imgurl) VALUES
( 'Esteban', 'Fernandez', 'efernandez@gmail.com', 'Professeur de Java', 'Je suis ingénieur en informatique et j''aime partager mes connaissances et mon expérience en tant que programmeur. J''ai travaillé dans plusieurs entreprises en Argentine, aux États-Unis et en Espagne. J''ai 2 ans d''expérience dans l''enseignement des matières suivantes : Internet, Java, Microsoft Office, C#, Visual Basic et SQL Server, aussi bien en entreprise qu''auprès d''étudiants privés.', 'https://i.imgur.com/hhuQ4yc.jpg'),
( 'Juana', 'Magdalena', 'jmagdalena@hotmail.com', 'Professeur de UX', '15 ans comme professionnel dans le monde de l''enseignement privé, donnant des cours dans des entreprises et dans différentes écoles de Paris et de Lille.', 'https://i.imgur.com/WwVezDt.jpg'),
( 'Pedro', 'Navaja', 'pnavaja@outlook.com', 'Professeur de Python', 'Ingénieur système, ayant de l''expérience dans le développement de logiciels et dans l''enseignement de cours de programmation de base, intermédiaire et avancée dans les langages Python, C/C++, Java, R, Matlab, Octave et JavaScript et dans les bases de données MySQL et PostgreSQL.', 'https://i.imgur.com/b2kSFna.jpg'),
( 'Maria', 'Mercedes', 'mmercedes@yahoo.com', 'Professeur de algoritmos', 'J''étudie l''informatique, et avant cela, j''ai étudié le génie informatique. J''aime enseigner pendant mon temps libre. J''ai le sentiment que ma méthodologie d''enseignement, qui consiste à donner des bases solides pour pouvoir ensuite élever le niveau avec des exercices intermédiaires et difficiles, aide mes élèves à évoluer et à avoir une vision du sujet qu''ils veulent apprendre. Mes cours sont agréables et je suis très patiente pour enseigner et comprendre, quel que soit leur niveau.', 'https://i.imgur.com/swUNc4x.jpg'),
('Alberto', 'Ibarra', 'aibarra@hotmail.com', 'Professeur de HTML','Ingénieur système ayant de l''expérience dans le développement de logiciels de bureau et web. Avec des connaissances dans les technologies telles que Java, PHP, Javascript, HTML, CSS. Je propose des cours à domicile aux étudiants ou à toute personne qui commence à apprendre ces technologies. J''enseigne également les frameworks Php comme Laravel, Javascript comme Vuejs et Css comme Bootstrap4.', 'https://i.imgur.com/rtb0xJF.jpg'),
('Jose', 'Domingo', 'jdomingo@hotmail.com', 'Professeur de Linux', 'Ingénieur en Réseaux et Communications, Master avec plus de 7 ans d''expérience dans le domaine de la Sécurité Informatique, Sécurité des Réseaux, Sécurité du Périmètre, Administration d''environnements de virtualisation et Administration de Systèmes d''Exploitation Linux - Windows. Avec la capacité d''enseigner Linux (basique, intermédiaire, avancé) Windows Server (basique, intermédiaire avancé)', 'https://i.imgur.com/r6yq088.jpg'),
('Stefany', 'Carranza', 'scarranza@gmail.com', 'Professeur de Javascript', 'Je suis développeur web dans une entreprise et je suis plongé dans le monde de la programmation et de l''informatique depuis l''âge de 15 ans. J''aime la programmation et tout ce qui est lié à l''internet et aux nouvelles technologies, créer des choses et enseigner aux autres. Je suis presque entièrement autodidacte, c''est pourquoi je vais vous offrir une grande partie de mes connaissances afin que vous puissiez apprendre plus facilement et plus rapidement que je l''ai fait et le fais chaque jour.', 'https://i.imgur.com/l053VCb.jpg'),
('Ismael', 'Lopez', 'slopez@outlook.com', 'Professeur de Base de Donées', 'Je travaille actuellement en tant que consultant pour une entreprise multinationale EVERIS SAC. Je suis chargé d''analyser et de programmer des solutions à des scénarios ou à des problèmes commerciaux. Je suis passionnée par l''enseignement et par le fait de pouvoir transmettre toutes mes connaissances.', 'https://i.imgur.com/Olu2PuN.jpg');
-- INSERTAR CURSOS
INSERT INTO curso (nombre, descripcion, profesor_id, detalle, dificultad, url, imgurl) VALUES
( 'Essential Java', 'Cours de JAVA débutans', 1, 'Si vous cherchez à apprendre à programmer en Java, ce cours vous permettra d''acquérir des connaissances en programmation orientée objet grâce à l''utilisation et à la gestion du langage. En outre, avec le cours de java, vous développerez des applications de console, des formulaires et des applets, des jsp pour l''internet et bien d''autres choses encore.', 'Facile', 'https://www.youtube.com/watch?v=_l4pJ7HCrl4&list=PLrSOXFDHBtfHkq8dd3BbSaopVgRSYtgPv', 'https://i.imgur.com/TYsitPM.jpg'),
( 'UX Principles', 'Cours sur l''expérience utilisateur', 2, 'Il existe de nombreuses raisons pour expliquer pourquoi vous devriez entrer dans le monde de l''expérience utilisateur, mais avant de commencer à les énumérer, savez-vous ce qu''est l''UX ? L''UX en espagnol se traduit par l''expérience de l''utilisateur. En termes généraux, il s''agit de ce qu''une personne perçoit lorsqu''elle interagit avec une plateforme. On considère que l''UX est bonne lorsque la conception, la disposition des éléments et la convivialité contribuent à rendre la navigation conviviale et facile à utiliser.', 'Facile', 'https://www.youtube.com/watch?v=aU44FDZQ6a8&list=PLqGe-TG4UU7d9_KlHtIKopZsx3qL5-3nm', 'https://i.imgur.com/6wp7WIL.jpg'),
( 'Advanced Python', 'Cours de Python avancé',3, 'Le cours Advanced Python est un cours 100% en ligne consacré aux dernières fonctionnalités du langage. De nature pratique, il vous permettra de maîtriser les récentes améliorations technologiques dans la réalisation de tous types de projets.', 'Avancé', 'https://www.youtube.com/watch?v=z6fV6_K2kkk&list=PLuWyq_EO5_AL9n8Xtt0Cn5UR_bL80e0IB', 'https://i.imgur.com/A8lUV2h.jpg'),
( 'Algorithms 101', 'Cours d''algorithmes pour débutants',4, 'À la base de toute solution en programmation, il y a un algorithme. Dans ce cours, nous vous présenterons la terminologie, les formes et la conception des algorithmes. Ce cours fait partie de notre spécialisation Introduction à la programmation, et vous apprend à résoudre des problèmes à l''aide d''algorithmes.', 'Facile', 'https://www.youtube.com/watch?v=kk6YbA5I-Iw&list=PL2aehqZh72Lumvy4tSekr6Rzcgwn15MLI', 'https://i.imgur.com/Xn6TdHy.jpg'),
( 'HTML Basics', 'Cours HTML pour débutants', 5, 'Le HTML est le langage sur lequel est construit l''ensemble du web et sa norme HTML5 l''a complètement révolutionné, faisant du navigateur le programme le plus utilisé au monde. Ce cours a été enseigné à la Faculté d''ingénierie des systèmes de l''Universidad Nacional Mayor de San Marcos à Lima, au Pérou, et est proposé entièrement gratuitement pour vous permettre de démarrer votre carrière dans le développement web.', 'Facile', 'https://www.youtube.com/watch?v=JDfz-0JXp4E&list=PL1aYsXmhJ1WcTNpqhWW0JinRlBgcGRhTn', 'https://i.imgur.com/gz7yrFb.jpg'),
( 'Advanced HTML', 'Curso HTML Avancé', 5, 'Apprenez les API HTML5 qui vous permettront de créer des applications web avec des capacités étendues, l''accès au matériel informatique de l''utilisateur, la géolocalisation, le stockage côté client et bien plus encore. L''apprentissage des API introduites par HTML5 vous aidera à élargir votre compréhension de ce que les pages peuvent faire.', 'Intermediaire', 'https://www.youtube.com/watch?v=QGSxIjjlu3k&list=PLgCfweEKfNwdBW5CBK_XLaD4Rw8sHi2Ur', 'https://i.imgur.com/i9DWWST.jpg'),
( 'Linux Essentials', 'Cours Linux Basic', 6, 'Linux est le système d''exploitation le plus largement adopté pour l''administration des serveurs sur Internet. Il maîtrise l''administration du système d''exploitation, des fichiers, des permissions, des utilisateurs et des paquets. Utiliser des outils pour surveiller les services et les processus. Configurez des tâches planifiées. Configurez la sécurité de votre serveur et de votre réseau pour réduire les vulnérabilités.', 'Facile', 'https://www.youtube.com/watch?v=py1E14pXfAM&list=PLrSOXFDHBtfHKxuz6NySItyf4iSEcTw97', 'https://i.imgur.com/GVTu9L4.jpg'),
( 'Bash Shell', 'Cours de Linux', 6, 'Tous les systèmes d''exploitation peuvent être programmés et exprimés en commandes. Par exemple, sous Windows, c''est CMD, sous Mac et Linux, c''est le terminal ou le "Shell". Ce langage est connu sous le nom de "Bash". Avec Bash-Shell, vous pouvez : manipuler des fichiers et des dossiers, exécuter des applications, vous connecter à des applications, automatiser des processus répétitifs et vous préparer de votre ordinateur personnel à un serveur en cloud.', 'Intermediaire', 'https://www.youtube.com/watch?v=py1E14pXfAM&list=PLrSOXFDHBtfHKxuz6NySItyf4iSEcTw97', 'https://i.imgur.com/6LzvoX1.jpg'),
( 'JavaScript Essential Training', 'Cours de Javascript Basic',7, 'Apprendre JavaScript, le langage de programmation le plus utilisé au monde après les anciens C et Java, est un langage avec lequel vous pouvez programmer en front-end d''une page web, ainsi qu''en back-end, vous pouvez également générer des applications hybrides pour les téléphones et bien plus encore. Le cours vous enseigne depuis les bases jusqu''à EcmaScript 5 et EcmaScript 6, les plus récentes versions de Javascript.', 'Facile', 'https://www.youtube.com/watch?v=VZLflMqC6dI&list=PLwLsbqvBlImFB8AuT6ENIg-s87ys4yGWI', 'https://i.imgur.com/5epwqY9.jpg'),
( 'Advanced JavaScript', 'Cours de Javascript Avancé',7, 'Améliorez vos compétences en Javascript. Apprenez à connaître Typescript et comment l''utiliser pour améliorer le contrôle de vos variables. Comprendre les concepts avancés qui vous permettent de trouver de meilleures solutions dans votre code. Apprenez à connaître les API DOM et découvrez comment vous pouvez mieux organiser votre code à l''aide de modèles de conception.', 'Intermediaire', 'https://www.youtube.com/watch?v=PoRwF_pwdH0&list=PL1aYsXmhJ1WceVjCYAPijGPNXEdjafbjx', 'https://i.imgur.com/vIBF1SA.jpg'),
( 'NodeJS Essential Training', 'Cours de NodeJS',7, 'Créer des applications dorsales en utilisant Node.js, Express et Mongo. Comprendre comment Javascript fonctionne sur un serveur et écrire des applications avec Node.js. Créez une API, gérez les erreurs et validez vos données avec Express. Testez votre code pour détecter les bogues et mettez enfin votre application en production sur un service web.', 'Avancé', 'https://www.youtube.com/watch?v=k7sn7dBh4eQ&list=PLT2KSPhMMiqq5VCDawcDMS_pQOhU77wl-', 'https://i.imgur.com/Uy5H4Ze.jpg'),
( 'SQL Essential Training', 'Cours SQL Basic',8, 'Apprenez à connaître le monde des bases de données pour comprendre leur fonctionnement, leur installation et les différences entre les différentes marques (SQL Server, MySQL, Oracle, etc.). Apprenez les bases du traitement et de la manipulation des données.', 'Facile', 'https://www.youtube.com/watch?v=pKuOAqKpGdw&list=PLFtlZvb4qwees1u9G58Iu0Vq_Dzj4zX5N', 'https://i.imgur.com/0ol7b83.jpg'),
( 'Advanced SQL', 'Cours SQL Avancé',8, 'Dans ce cours, vous apprendrez les règles qui doivent être prises en compte lors du processus de modélisation et de conception de bases de données, ainsi que le langage nécessaire à la création d''objets de base de données et à la manipulation d''informations à partir d''un gestionnaire de base de données.', 'Avancé', 'https://www.youtube.com/watch?v=pKuOAqKpGdw&list=PLFtlZvb4qwees1u9G58Iu0Vq_Dzj4zX5N', 'https://i.imgur.com/0jCGazt.jpg'),
( 'MongoDB Essential Training', 'Cours de MongoDB',8, 'Maîtrisez les bases de données MongoDB, le moteur NoSQL qui offre une grande capacité de stockage. Optimisez vos processus grâce à la rapidité des requêtes et profitez de l''évolutivité de ce type de base de données dans vos projets.', 'Intermediaire', 'https://www.youtube.com/watch?v=hleXAY39QmI&list=PLCs3nw0HhoAlhHGmv0UwGjvxnMliMcZGS', 'https://i.imgur.com/qm8cxhp.jpg');
-- INSERTAR MATRICULAS
INSERT INTO matricula (user_id, curso_id, fecha) VALUES ( 1, 3, '2019-10-10' ),
                                                        ( 2, 1, '2019-11-01'),
                                                        ( 2, 4, '2019-11-02' );
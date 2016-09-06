INSERT INTO Conducteur (id,loginConducteur,mdpConducteur,mailConducteur,telConducteur,immatriculation,nbPlaces,latitude,longitude,prixAuKm)
VALUES (1,'seb','seb','seb@seb.fr','0600010203','EH-789-PQ',2,50.62,3.1,0.10),
       (2,'jay','jay','jay@jay.fr','0708090405','AB-456-BG',7,50.63,3.12,10),
       (3,'sab','sab','sab@sab.fr','0801020603','FS-123-CG',1,50.69,3.13,0.33);

INSERT INTO Passager (id,loginPassager,mdpPassager,mailPassager,telPassager)
VALUES (1,'Kevin','beauf','kevin@kevin.fr','01020304'),
       (2,'Brian','bobo','brian@brian.fr','0605040302'),
       (3,'Dylan','keke','dylan@dylan.fr','05010203');

INSERT INTO  Historique (id,passager_id,conducteur_id,depart,arrivee,prix,nbPassager,modePaiement)
VALUES (1,1,1,'456 rue de la Croix','18 rue du planté de baton',190,5,'CB'),
       (2,1,2,'78 avenue du calvaire','69 impasse du plaisir',69.95,2,'NATURE'),
       (3,2,1,'120 route Gilles de la tourette','45 allée des infirmiers',80,6,'TROC');









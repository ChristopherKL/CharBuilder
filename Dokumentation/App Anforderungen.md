# Anforderungen

## Must Have
Als wichtigste Funktion der App gilt das Erstellen eines neuen Charakters. Es muss möglich sein einen Charakter entsprechend des gewählten Regelwerks zu erstellen. Zunächst wird es nur möglich sein Charaktere im Regelwerk *Star Wars: Am Rande des Imperiums* zu erschaffen. Während des Erstellungsprozesses kann der Nutzer auf Regeltexte zurückgreifen, die ihm seine aktuellen Auswahlmöglichkeiten erklären. Diese Regeltexte werden aufgrund von eventuellen Urheberrechtsverletzungen nicht aus dem offiziellen Regelwerk kopiert, sondern von den Entwicklern der App zusammengefasst.

Nachdem der Nutzer einen Charakter erstellt hat, wird dieser in einer Liste mit anderen, bereits von ihm angelegten, Charakteren angezeigt. In der Liste wird das für den Charakter ausgewählte Bild, sein Name und das Regelwerk, in dem er gespielt wird, dargestellt. Der Nutzer kann nicht mehr benötigte Einträge aus der Liste löschen, Änderungen an den Charakteren vornehmen und diese als PDF-Datei exportieren. Durch einen Klick auf einen der Listeneinträge werden dem Nutzer alle Eigenschaften, Talente, Spezialisierungen, etc. zu einem Charakter angezeigt.

Eine weitere Funktion der App ist das eingebaute Würfeltool. Wenn der Nutzer sich in der Detailansicht zu einem seiner Charaktere befindet, kann er ohne großen Aufwand Proben auf seine Fähigkeiten werfen. Es wird dann berechnet, ob die Probe erfolgreich war oder nicht und das Ergebnis wird sichtbar. Außerdem wird die Probe im Verlauf des Würfeltools angezeigt, sodass der Nutzer eine Übersicht seiner vorherigen Proben erhält. Das Würfeltool ist über die Navigationsleiste erreichbar und bietet eine Auswahl an benötigten Würfeln an.

## Should Have
Es sollte eine Anbindung an die Google Cloud geben, in der der Nutzer seine Charaktere speichern kann. Des Weiteren können sie als JSON-Datei exportiert werden.

## Could Have
Es wird nicht ausgeschlossen, dass die App die Erstellung von Charakteren in unterschiedlichen Regelwerken ermöglicht. Allerdings gibt es große Unterschiede in der Komplexität und dem Umfang von Pen and Paper Regelwerken, weswegen zunächst nur ein Regelwerk unterstützt wird.

## Won't Have
Die App wird keine Gruppenverwaltung ermöglichen. Das bedeutet, dass ein Spielleiter nicht die Charaktere seiner Gruppenmitglieder einsehen kann. Außerdem werden in der App keine spielbaren Abenteuer vorhanden sein. Sie dient lediglich dem Speichern und Verwalten von Pen and Paper Charakteren.

# Die Charaktererstellung
Da die Erstellung eines Charakters im offiziellen Regelwerk bereits in sinnvolle Schritte unterteilt war, wollten wir diese Gliederung in der App wiederspiegeln. Durch das Bewahren der in den Regeln eingeführten Struktur haben neue Spieler einen guten Überblick über die für die Charaktererstellung benötigten Schritte. Außerdem müssen sich Spieler, die das offizielle Regelwerk bereits kennen, nicht an eine neue Gliederung gewöhnen. In der App werden die Schritte durch *Fragmente* dargestellt. Jedes *Fragment* besitzt ein eigenes Layout, das an die Anforderungen des jeweiligen Erstellungsschritts angepasst ist. Um zwischen den einzelnen *Fragmenten* navigieren zu können, haben wir uns für ein *TabLayout* entschieden. Dadurch kann der Nutzer zu jeder Zeit während der Erstellung sehen, wie viele Schritte er noch bearbeiten muss. Außerdem hat der Nutzer so die Möglichkeit, im Erstellungsprozess hin und her zuspringen, falls er in vorherigen *Fragmenten* Änderungen vornehmen möchte.

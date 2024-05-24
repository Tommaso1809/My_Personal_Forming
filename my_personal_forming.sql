-- phpMyAdmin SQL Dump
-- version 4.7.1
-- https://www.phpmyadmin.net/
--
-- Host: sql7.freesqldatabase.com
-- Creato il: Mag 24, 2024 alle 17:46
-- Versione del server: 5.5.62-0ubuntu0.14.04.1
-- Versione PHP: 7.0.33-0ubuntu0.16.04.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sql7708180`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `assegnato`
--

CREATE TABLE `assegnato` (
  `ID` int(11) NOT NULL,
  `utente` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `assegnato`
--

INSERT INTO `assegnato` (`ID`, `utente`) VALUES
(1, 'test'),
(1, 'ttt'),
(1, 'Polvere'),
(1, 'Polvere'),
(1, 'Polvere'),
(2, 'Polvere');

-- --------------------------------------------------------

--
-- Struttura della tabella `associato`
--

CREATE TABLE `associato` (
  `ID_corso` int(11) DEFAULT NULL,
  `ID_attestato` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `attestato`
--

CREATE TABLE `attestato` (
  `ID` int(11) NOT NULL,
  `filename` longblob NOT NULL,
  `nome_formazione` varchar(32) NOT NULL,
  `data_formazione` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `attestato`
--

INSERT INTO `attestato` (`ID`, `filename`, `nome_formazione`, `data_formazione`) VALUES
(1, 0x6369616f20636f6d65207661, 'Sicurezza su lavoro', 'test'),
(2, 0x6369616f20636f6d65207661, 'Sicurezza su lavoro', 's');

-- --------------------------------------------------------

--
-- Struttura della tabella `corso`
--

CREATE TABLE `corso` (
  `ID` int(11) NOT NULL,
  `nome_formazione` varchar(30) DEFAULT NULL,
  `durata_formazione` varchar(30) DEFAULT NULL,
  `categoria` varchar(32) DEFAULT NULL,
  `stato` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `corso`
--

INSERT INTO `corso` (`ID`, `nome_formazione`, `durata_formazione`, `categoria`, `stato`) VALUES
(1, 'Sicurezza su lavoro', '12 ore', 'sicurezza aziendale', 'disponibile'),
(2, 'Formazione sui DPI', '10 ore', 'Aziendale', 'disponibile');

-- --------------------------------------------------------

--
-- Struttura della tabella `possiede`
--

CREATE TABLE `possiede` (
  `ID` int(11) DEFAULT NULL,
  `utente` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `possiede`
--

INSERT INTO `possiede` (`ID`, `utente`) VALUES
(1, 'ttt'),
(2, 'test');

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `email` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nome` varchar(32) NOT NULL,
  `cognome` varchar(32) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `data_nascita` varchar(20) NOT NULL,
  `ruolo` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`email`, `password`, `nome`, `cognome`, `telefono`, `data_nascita`, `ruolo`) VALUES
('davde4744@gail.com', '1234', 'davide', 'cartacci', '33336220ed', '06122005', ' '),
('t', '1234', 'Tommaso', 'Polvere', '123456', '18 Settembre', 'Designer'),
('test', '1234', 'test', 'test', 'test', 'test', 'Sviluppatore'),
('tommasopolvere18@gmail.com', '1234', 'Tommaso', 'Polvere', '354088691', '18 Settembre 2005', ' '),
('ttt', '1234', 't', 't', 'j', 'v', 'titolare');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `assegnato`
--
ALTER TABLE `assegnato`
  ADD KEY `ID` (`ID`);

--
-- Indici per le tabelle `associato`
--
ALTER TABLE `associato`
  ADD KEY `ID_corso` (`ID_corso`),
  ADD KEY `ID_attestato` (`ID_attestato`);

--
-- Indici per le tabelle `attestato`
--
ALTER TABLE `attestato`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `corso`
--
ALTER TABLE `corso`
  ADD PRIMARY KEY (`ID`);

--
-- Indici per le tabelle `possiede`
--
ALTER TABLE `possiede`
  ADD KEY `utente` (`utente`),
  ADD KEY `ID` (`ID`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `attestato`
--
ALTER TABLE `attestato`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT per la tabella `corso`
--
ALTER TABLE `corso`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `assegnato`
--
ALTER TABLE `assegnato`
  ADD CONSTRAINT `assegnato_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `corso` (`ID`);

--
-- Limiti per la tabella `associato`
--
ALTER TABLE `associato`
  ADD CONSTRAINT `associato_ibfk_1` FOREIGN KEY (`ID_corso`) REFERENCES `corso` (`ID`),
  ADD CONSTRAINT `associato_ibfk_2` FOREIGN KEY (`ID_attestato`) REFERENCES `attestato` (`ID`);

--
-- Limiti per la tabella `possiede`
--
ALTER TABLE `possiede`
  ADD CONSTRAINT `possiede_ibfk_1` FOREIGN KEY (`utente`) REFERENCES `utente` (`email`),
  ADD CONSTRAINT `possiede_ibfk_2` FOREIGN KEY (`ID`) REFERENCES `attestato` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

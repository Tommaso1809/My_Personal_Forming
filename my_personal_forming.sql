-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 11, 2024 alle 11:50
-- Versione del server: 10.4.28-MariaDB
-- Versione PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `my_personal_forming`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `associato`
--

CREATE TABLE `associato` (
  `ID_corso` int(11) DEFAULT NULL,
  `ID_attestato` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `attestato`
--

CREATE TABLE `attestato` (
  `ID` int(11) NOT NULL,
  `nome_formazione` varchar(32) NOT NULL,
  `data_formazione` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `possiede`
--

CREATE TABLE `possiede` (
  `ID` int(11) DEFAULT NULL,
  `utente` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  `ruolo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `utente`
--

INSERT INTO `utente` (`email`, `password`, `nome`, `cognome`, `telefono`, `data_nascita`, `ruolo`) VALUES
('t@gmail.com', '', 'Tommaso', 'Polvere', '1234', '18 Settembre 2005', '');

--
-- Indici per le tabelle scaricate
--

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `corso`
--
ALTER TABLE `corso`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Limiti per le tabelle scaricate
--

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

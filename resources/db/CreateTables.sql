-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`MJESTO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MJESTO` (
  `PoštanskiBroj` VARCHAR(5) NOT NULL,
  `Naziv` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`PoštanskiBroj`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OSOBA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OSOBA` (
  `IdOsoba` INT NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(50) NOT NULL,
  `Prezime` VARCHAR(50) NOT NULL,
  `Telefon` VARCHAR(15) NOT NULL,
  `MJESTO_PoštanskiBroj` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`IdOsoba`),
  INDEX `fk_OSOBA_MJESTO1_idx` (`MJESTO_PoštanskiBroj` ASC) VISIBLE,
  CONSTRAINT `fk_OSOBA_MJESTO1`
    FOREIGN KEY (`MJESTO_PoštanskiBroj`)
    REFERENCES `mydb`.`MJESTO` (`PoštanskiBroj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`NARUDŽBA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`NARUDŽBA` (
  `IdNarudžba` INT NOT NULL AUTO_INCREMENT,
  `Datum` DATETIME NOT NULL,
  `Status` TINYINT NOT NULL DEFAULT 0,
  `UkupnaCijena` DECIMAL(7,2) NOT NULL,
  `AdresaMontaže` VARCHAR(200) NULL,
  `OSOBA_IdOsoba` INT NOT NULL,
  PRIMARY KEY (`IdNarudžba`),
  INDEX `fk_NARUDŽBA_OSOBA1_idx` (`OSOBA_IdOsoba` ASC) VISIBLE,
  CONSTRAINT `fk_NARUDŽBA_OSOBA1`
    FOREIGN KEY (`OSOBA_IdOsoba`)
    REFERENCES `mydb`.`OSOBA` (`IdOsoba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ARTIKAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ARTIKAL` (
  `IdArtikal` INT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(200) NOT NULL,
  `Cijena` DECIMAL(7,2) NOT NULL,
  `Opis` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`IdArtikal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`STAVKA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`STAVKA` (
  `NARUDŽBA_IdNarudžba` INT NOT NULL,
  `ARTIKAL_IdArtikal` INT NOT NULL,
  `Količina` INT NOT NULL,
  PRIMARY KEY (`NARUDŽBA_IdNarudžba`, `ARTIKAL_IdArtikal`),
  INDEX `fk_NARUDŽBA_has_ARTIKAL_ARTIKAL1_idx` (`ARTIKAL_IdArtikal` ASC) VISIBLE,
  INDEX `fk_NARUDŽBA_has_ARTIKAL_NARUDŽBA_idx` (`NARUDŽBA_IdNarudžba` ASC) VISIBLE,
  CONSTRAINT `fk_NARUDŽBA_has_ARTIKAL_NARUDŽBA`
    FOREIGN KEY (`NARUDŽBA_IdNarudžba`)
    REFERENCES `mydb`.`NARUDŽBA` (`IdNarudžba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NARUDŽBA_has_ARTIKAL_ARTIKAL1`
    FOREIGN KEY (`ARTIKAL_IdArtikal`)
    REFERENCES `mydb`.`ARTIKAL` (`IdArtikal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`TIP_OPREME`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TIP_OPREME` (
  `IdTipOpreme` TINYINT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IdTipOpreme`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PROIZVOĐAČ_OPREME`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PROIZVOĐAČ_OPREME` (
  `IdProizvođača` TINYINT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IdProizvođača`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OPREMA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OPREMA` (
  `TrajanjeGarancije` TINYINT NOT NULL DEFAULT 0,
  `ARTIKAL_IdArtikal` INT NOT NULL,
  `TIP_OPREME_IdTipOpreme` TINYINT NOT NULL,
  `PROIZVOĐAČ_OPREME_IdProizvođača` TINYINT NOT NULL,
  PRIMARY KEY (`ARTIKAL_IdArtikal`),
  INDEX `fk_OPREMA_TIP_OPREME1_idx` (`TIP_OPREME_IdTipOpreme` ASC) VISIBLE,
  INDEX `fk_OPREMA_PROIZVOĐAČ_OPREME1_idx` (`PROIZVOĐAČ_OPREME_IdProizvođača` ASC) VISIBLE,
  CONSTRAINT `fk_OPREMA_ARTIKAL1`
    FOREIGN KEY (`ARTIKAL_IdArtikal`)
    REFERENCES `mydb`.`ARTIKAL` (`IdArtikal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OPREMA_TIP_OPREME1`
    FOREIGN KEY (`TIP_OPREME_IdTipOpreme`)
    REFERENCES `mydb`.`TIP_OPREME` (`IdTipOpreme`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OPREMA_PROIZVOĐAČ_OPREME1`
    FOREIGN KEY (`PROIZVOĐAČ_OPREME_IdProizvođača`)
    REFERENCES `mydb`.`PROIZVOĐAČ_OPREME` (`IdProizvođača`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MONTAŽNI_ARTIKAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MONTAŽNI_ARTIKAL` (
  `ARTIKAL_IdArtikal` INT NOT NULL,
  `PrečnikBazena` DECIMAL(3,2) NOT NULL,
  `DubinaBazena` DECIMAL(3,2) NOT NULL,
  PRIMARY KEY (`ARTIKAL_IdArtikal`),
  CONSTRAINT `fk_MONTAŽNI_ARTIKAL_ARTIKAL1`
    FOREIGN KEY (`ARTIKAL_IdArtikal`)
    REFERENCES `mydb`.`ARTIKAL` (`IdArtikal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ULOGA_ZAPOSLENOG`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ULOGA_ZAPOSLENOG` (
  `IdUloga` TINYINT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IdUloga`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ZAPOSLENI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ZAPOSLENI` (
  `KorisničkoIme` VARCHAR(50) NOT NULL,
  `OtisakLozinke` VARCHAR(512) NOT NULL,
  `Plata` DECIMAL(6,2) NOT NULL,
  `JMBG` VARCHAR(13) NOT NULL,
  `OSOBA_IdOsoba` INT NOT NULL,
  `ULOGA_ZAPOSLENOG_IdUloga` TINYINT NOT NULL,
  PRIMARY KEY (`OSOBA_IdOsoba`),
  INDEX `fk_ZAPOSLENI_ULOGA_ZAPOSLENOG1_idx` (`ULOGA_ZAPOSLENOG_IdUloga` ASC) VISIBLE,
  CONSTRAINT `fk_ZAPOSLENI_OSOBA1`
    FOREIGN KEY (`OSOBA_IdOsoba`)
    REFERENCES `mydb`.`OSOBA` (`IdOsoba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZAPOSLENI_ULOGA_ZAPOSLENOG1`
    FOREIGN KEY (`ULOGA_ZAPOSLENOG_IdUloga`)
    REFERENCES `mydb`.`ULOGA_ZAPOSLENOG` (`IdUloga`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ZAPOSLENI_montira_MONTAŽNI_ARTIKAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ZAPOSLENI_montira_MONTAŽNI_ARTIKAL` (
  `ZAPOSLENI_OSOBA_IdOsoba` INT NOT NULL,
  `MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal` INT NOT NULL,
  `DatumPočetkaMontaže` DATE NOT NULL,
  `DatumZavršetkaMontaže` DATE NOT NULL,
  PRIMARY KEY (`ZAPOSLENI_OSOBA_IdOsoba`, `MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal`),
  INDEX `fk_ZAPOSLENI_has_MONTAŽNI_ARTIKAL_MONTAŽNI_ARTIKAL1_idx` (`MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal` ASC) VISIBLE,
  INDEX `fk_ZAPOSLENI_has_MONTAŽNI_ARTIKAL_ZAPOSLENI1_idx` (`ZAPOSLENI_OSOBA_IdOsoba` ASC) VISIBLE,
  CONSTRAINT `fk_ZAPOSLENI_has_MONTAŽNI_ARTIKAL_ZAPOSLENI1`
    FOREIGN KEY (`ZAPOSLENI_OSOBA_IdOsoba`)
    REFERENCES `mydb`.`ZAPOSLENI` (`OSOBA_IdOsoba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZAPOSLENI_has_MONTAŽNI_ARTIKAL_MONTAŽNI_ARTIKAL1`
    FOREIGN KEY (`MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal`)
    REFERENCES `mydb`.`MONTAŽNI_ARTIKAL` (`ARTIKAL_IdArtikal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OBLOGA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`OBLOGA` (
  `VrstaMaterijala` VARCHAR(50) NOT NULL,
  `MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal` INT NOT NULL,
  PRIMARY KEY (`MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal`),
  CONSTRAINT `fk_OBLOGA_MONTAŽNI_ARTIKAL1`
    FOREIGN KEY (`MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal`)
    REFERENCES `mydb`.`MONTAŽNI_ARTIKAL` (`ARTIKAL_IdArtikal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PLATFORMA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PLATFORMA` (
  `KvadraturaPodesta` DECIMAL(4,2) NOT NULL,
  `VrstaMaterijala` VARCHAR(50) NOT NULL,
  `MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal` INT NOT NULL,
  PRIMARY KEY (`MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal`),
  CONSTRAINT `fk_PLATFORMA_MONTAŽNI_ARTIKAL1`
    FOREIGN KEY (`MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal`)
    REFERENCES `mydb`.`MONTAŽNI_ARTIKAL` (`ARTIKAL_IdArtikal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BAZEN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`BAZEN` (
  `MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal` INT NOT NULL,
  PRIMARY KEY (`MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal`),
  CONSTRAINT `fk_BAZEN_MONTAŽNI_ARTIKAL1`
    FOREIGN KEY (`MONTAŽNI_ARTIKAL_ARTIKAL_IdArtikal`)
    REFERENCES `mydb`.`MONTAŽNI_ARTIKAL` (`ARTIKAL_IdArtikal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MJERNA_JEDINICA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MJERNA_JEDINICA` (
  `IdMjernaJedinica` TINYINT NOT NULL AUTO_INCREMENT,
  `Oznaka` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`IdMjernaJedinica`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`VRSTA_MATERIJALA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`VRSTA_MATERIJALA` (
  `IdVrsteMaterijala` TINYINT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IdVrsteMaterijala`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MATERIJAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`MATERIJAL` (
  `IdMaterijal` INT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(100) NOT NULL,
  `Količina` DECIMAL(5,2) NOT NULL,
  `MJERNA_JEDINICA_IdMjernaJedinica` TINYINT NOT NULL,
  `VRSTA_MATERIJALA_IdVrsteMaterijala` TINYINT NOT NULL,
  PRIMARY KEY (`IdMaterijal`),
  INDEX `fk_MATERIJAL_MJERNA_JEDINICA1_idx` (`MJERNA_JEDINICA_IdMjernaJedinica` ASC) VISIBLE,
  INDEX `fk_MATERIJAL_VRSTA_MATERIJALA1_idx` (`VRSTA_MATERIJALA_IdVrsteMaterijala` ASC) VISIBLE,
  CONSTRAINT `fk_MATERIJAL_MJERNA_JEDINICA1`
    FOREIGN KEY (`MJERNA_JEDINICA_IdMjernaJedinica`)
    REFERENCES `mydb`.`MJERNA_JEDINICA` (`IdMjernaJedinica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_MATERIJAL_VRSTA_MATERIJALA1`
    FOREIGN KEY (`VRSTA_MATERIJALA_IdVrsteMaterijala`)
    REFERENCES `mydb`.`VRSTA_MATERIJALA` (`IdVrsteMaterijala`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ARTIKAL_sadrži_MATERIJAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ARTIKAL_sadrži_MATERIJAL` (
  `ARTIKAL_IdArtikal` INT NOT NULL,
  `MATERIJAL_IdMaterijal` INT NOT NULL,
  `NabavnaCijena` DECIMAL(6,2) NOT NULL,
  `UtrošenaKoličina` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`ARTIKAL_IdArtikal`, `MATERIJAL_IdMaterijal`, `NabavnaCijena`),
  INDEX `fk_ARTIKAL_has_MATERIJAL_MATERIJAL1_idx` (`MATERIJAL_IdMaterijal` ASC) VISIBLE,
  INDEX `fk_ARTIKAL_has_MATERIJAL_ARTIKAL1_idx` (`ARTIKAL_IdArtikal` ASC) VISIBLE,
  CONSTRAINT `fk_ARTIKAL_has_MATERIJAL_ARTIKAL1`
    FOREIGN KEY (`ARTIKAL_IdArtikal`)
    REFERENCES `mydb`.`ARTIKAL` (`IdArtikal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ARTIKAL_has_MATERIJAL_MATERIJAL1`
    FOREIGN KEY (`MATERIJAL_IdMaterijal`)
    REFERENCES `mydb`.`MATERIJAL` (`IdMaterijal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PARTNERSKA_KOMPANIJA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PARTNERSKA_KOMPANIJA` (
  `IdPartnerskaKompanija` TINYINT NOT NULL,
  `Naziv` VARCHAR(200) NOT NULL,
  `Adresa` VARCHAR(200) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `Telefon` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`IdPartnerskaKompanija`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`NARUDŽBENICA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`NARUDŽBENICA` (
  `IdNarudžbenica` INT NOT NULL AUTO_INCREMENT,
  `Status` TINYINT NOT NULL,
  `VrijemeKupovine` DATETIME NOT NULL,
  `PARTNERSKA_KOMPANIJA_IdPartnerskaKompanija` TINYINT NOT NULL,
  `ZAPOSLENI_OSOBA_IdOsoba` INT NULL,
  PRIMARY KEY (`IdNarudžbenica`),
  INDEX `fk_NARUDŽBENICA_PARTNERSKA_KOMPANIJA1_idx` (`PARTNERSKA_KOMPANIJA_IdPartnerskaKompanija` ASC) VISIBLE,
  INDEX `fk_NARUDŽBENICA_ZAPOSLENI1_idx` (`ZAPOSLENI_OSOBA_IdOsoba` ASC) VISIBLE,
  CONSTRAINT `fk_NARUDŽBENICA_PARTNERSKA_KOMPANIJA1`
    FOREIGN KEY (`PARTNERSKA_KOMPANIJA_IdPartnerskaKompanija`)
    REFERENCES `mydb`.`PARTNERSKA_KOMPANIJA` (`IdPartnerskaKompanija`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NARUDŽBENICA_ZAPOSLENI1`
    FOREIGN KEY (`ZAPOSLENI_OSOBA_IdOsoba`)
    REFERENCES `mydb`.`ZAPOSLENI` (`OSOBA_IdOsoba`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`NARUDŽBENICA_ima_MATERIJAL`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`NARUDŽBENICA_ima_MATERIJAL` (
  `NARUDŽBENICA_IdNarudžbenica` INT NOT NULL,
  `MATERIJAL_IdMaterijal` INT NOT NULL,
  `Količina` DECIMAL(5,2) NOT NULL,
  `NabavnaCijena` DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (`NARUDŽBENICA_IdNarudžbenica`, `MATERIJAL_IdMaterijal`),
  INDEX `fk_NARUDŽBENICA_has_MATERIJAL_MATERIJAL1_idx` (`MATERIJAL_IdMaterijal` ASC) VISIBLE,
  INDEX `fk_NARUDŽBENICA_has_MATERIJAL_NARUDŽBENICA1_idx` (`NARUDŽBENICA_IdNarudžbenica` ASC) VISIBLE,
  CONSTRAINT `fk_NARUDŽBENICA_has_MATERIJAL_NARUDŽBENICA1`
    FOREIGN KEY (`NARUDŽBENICA_IdNarudžbenica`)
    REFERENCES `mydb`.`NARUDŽBENICA` (`IdNarudžbenica`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_NARUDŽBENICA_has_MATERIJAL_MATERIJAL1`
    FOREIGN KEY (`MATERIJAL_IdMaterijal`)
    REFERENCES `mydb`.`MATERIJAL` (`IdMaterijal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`KOMPANIJA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`KOMPANIJA` (
  `JIB` VARCHAR(16) NOT NULL,
  `Naziv` VARCHAR(200) NOT NULL,
  `Adresa` VARCHAR(200) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `Telefon` VARCHAR(15) NOT NULL,
  `OdgovornoLice` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`JIB`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

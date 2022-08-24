package no.nav.bidrag.behandling.felles.dto.grunnlag

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.GrunnlagRequestType
import no.nav.bidrag.behandling.felles.enums.GrunnlagsRequestStatus
import no.nav.bidrag.behandling.felles.enums.SivilstandKode
import no.nav.bidrag.behandling.felles.enums.barnetilsyn.Skolealder
import no.nav.bidrag.behandling.felles.enums.barnetilsyn.Tilsyntype
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime


@Schema(description = "Respons ved oppdatering av  grunnlagspakke")
data class OppdaterGrunnlagspakkeDto(

  @Schema(description = "Grunnlagspakke-id")
  val grunnlagspakkeId: Int,

  @Schema(description = "Liste over grunnlagene som er hentet inn med person-id og status")
  val grunnlagTypeResponsListe: List<OppdaterGrunnlagDto>
)


data class OppdaterGrunnlagDto(

  @Schema(description = "Hvilken type grunnlag som er hentet")
  val type: GrunnlagRequestType,

  @Schema(description = "Angir personId som grunnlag er hentet for")
  val personId: String,

  @Schema(description = "Status for utført kall")
  val status: GrunnlagsRequestStatus,

  @Schema(description = "Statusmelding for utført kall")
  val statusMelding: String,

  )


data class HentGrunnlagspakkeDto(

  @Schema(description = "grunnlagspakke-id")
  val grunnlagspakkeId: Int,

  @Schema(description = "Periodisert liste over innhentede inntekter fra a-inntekt og underliggende poster")
  val ainntektListe: List<AinntektDto>,

  @Schema(description = "Periodisert liste over innhentede fra skatt og underliggende poster")
  val skattegrunnlagListe: List<SkattegrunnlagDto>,

  @Schema(description = "Periodisert liste over innhentet utvidet barnetrygd og småbarnstillegg")
  val ubstListe: List<UtvidetBarnetrygdOgSmaabarnstilleggDto>,

  @Schema(description = "Periodisert liste over innhentet barnetillegg")
  val barnetilleggListe: List<BarnetilleggDto>,

  @Schema(description = "Periodisert liste over innhentet kontantstøtte")
  val kontantstotteListe: List<KontantstotteDto>,

  @Schema(description = "Liste over en persons barn og hvilke perioder de eventuelt deler husstand med personen grunnlaget er hentet inn for")
  val egneBarnListe: List<EgneBarnDto>,

  @Schema(description = "Periodisert liste over innhentede husstander for en person og dens voksne husstandsmedlemmer")
  val husstandListe: List<HusstandDto>,

  @Schema(description = "Periodisert liste over en persons sivilstand")
  val sivilstandListe: List<SivilstandDto>,

  @Schema(description = "Periodisert liste over innhentet barnetilsyn")
  val barnetilsynListe: List<BarnetilsynDto>

)


data class AinntektDto(

  @Schema(description = "Id til personen inntekten er rapportert for")
  val personId: String,

  @Schema(description = "Periode fra-dato")
  val periodeFra: LocalDate,

  @Schema(description = "Periode til-dato")
  val periodeTil: LocalDate,

  @Schema(description = "Angir om en inntektsopplysning er aktiv")
  val aktiv: Boolean,

  @Schema(description = "Tidspunkt inntekten taes i bruk")
  val brukFra: LocalDateTime,

  @Schema(description = "Tidspunkt inntekten ikke lenger er aktiv. Null betyr at inntekten er aktiv")
  val brukTil: LocalDateTime?,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime,

  @Schema(description = "Liste over poster for innhentede inntektsposter")
  val ainntektspostListe: List<AinntektspostDto>
)


data class AinntektspostDto (

  @Schema(description = "Perioden innteksposten er utbetalt YYYYMM")
  val utbetalingsperiode: String?,

  @Schema(description = "Fra-dato for opptjening")
  val opptjeningsperiodeFra: LocalDate?,

  @Schema(description = "Til-dato for opptjening")
  val opptjeningsperiodeTil: LocalDate?,

  @Schema(description = "Id til de som rapporterer inn inntekten")
  val opplysningspliktigId: String?,

  @Schema(description = "Id til virksomheten som rapporterer inn inntekten")
  val virksomhetId: String?,

  @Schema(description = "Type inntekt, Lonnsinntekt, Naeringsinntekt, Pensjon eller trygd, Ytelse fra offentlig")
  val inntektType: String,

  @Schema(description = "Type fordel, Kontantytelse, Naturalytelse, Utgiftsgodtgjorelse")
  val fordelType: String?,

  @Schema(description = "Beskrivelse av inntekt")
  val beskrivelse: String?,

  @Schema(description = "Belop")
  val belop: BigDecimal,

  @Schema(description = "Fra-dato etterbetaling")
  val etterbetalingsperiodeFra: LocalDate?,

  @Schema(description = "Til-dato etterbetaling")
  val etterbetalingsperiodeTil: LocalDate?
)


data class SkattegrunnlagDto(

  @Schema(description = "Id til personen inntekten er rapportert for")
  val personId: String,

  @Schema(description = "Periode fra")
  val periodeFra: LocalDate,

  @Schema(description = "Periode frem til")
  val periodeTil: LocalDate,

  @Schema(description = "Angir om en inntektsopplysning er aktiv")
  val aktiv: Boolean,

  @Schema(description = "Tidspunkt inntekten taes i bruk")
  val brukFra: LocalDateTime,

  @Schema(description = "Tidspunkt inntekten ikke lenger er aktiv. Null betyr at inntekten er aktiv")
  val brukTil: LocalDateTime?,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime,

  @Schema(description = "Liste over poster med skattegrunnlag")
  val skattegrunnlagListe: List<SkattegrunnlagspostDto>
)


data class SkattegrunnlagspostDto(

  @Schema(description = "Type skattegrunnlag, ordinær eller Svalbard")
  val skattegrunnlagType: String,

  @Schema(description = "Type inntekt, Lonnsinntekt, Naeringsinntekt, Pensjon eller trygd, Ytelse fra offentlig")
  val inntektType: String,

  @Schema(description = "Belop")
  val belop: BigDecimal
)


data class UtvidetBarnetrygdOgSmaabarnstilleggDto(

  @Schema(description = "Id til personen ubst er rapportert for")
  val personId: String,

  @Schema(description = "Type stønad, utvidet barnetrygd eller småbarnstillegg")
  val type: String,

  @Schema(description = "Periode fra- og med måned")
  val periodeFra: LocalDate,

  @Schema(description = "Periode til- og med måned")
  val periodeTil: LocalDate?,

  @Schema(description = "Angir om en stønad er aktiv")
  val aktiv: Boolean,

  @Schema(description = "Tidspunkt stønaden taes i bruk")
  val brukFra: LocalDateTime,

  @Schema(description = "Tidspunkt stønaden ikke lenger er aktiv. Null betyr at stønaden er aktiv")
  val brukTil: LocalDateTime?,

  @Schema(description = "Beløp")
  val belop: BigDecimal,

  @Schema(description = "Angir om stønaden er manuelt beregnet")
  val manueltBeregnet: Boolean,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime,
)


data class BarnetilleggDto(

  @Schema(description = "Id til personen barnetillegg er rapportert for")
  val partPersonId: String,

  @Schema(description = "Id til barnet barnetillegget er rapportert for")
  val barnPersonId: String,

  @Schema(description = "Type barnetillegg")
  val barnetilleggType: String,

  @Schema(description = "Periode fra- og med måned")
  val periodeFra: LocalDate,

  @Schema(description = "Periode til- og med måned")
  val periodeTil: LocalDate?,

  @Schema(description = "Angir om en stønad er aktiv")
  val aktiv: Boolean,

  @Schema(description = "Tidspunkt stønaden taes i bruk")
  val brukFra: LocalDateTime,

  @Schema(description = "Tidspunkt stønaden ikke lenger er aktiv. Null betyr at stønaden er aktiv")
  val brukTil: LocalDateTime?,

  @Schema(description = "Bruttobeløp")
  val belopBrutto: BigDecimal,

  @Schema(description = "Angir om barnet er felles- eller særkullsbarn")
  val barnType: String,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime,
)

data class KontantstotteDto(

  @Schema(description = "Id til personen som mottar kontatstøtten")
  val partPersonId: String,

  @Schema(description = "Id til barnet kontatstøtten er for")
  val barnPersonId: String,

  @Schema(description = "Periode fra-dato")
  val periodeFra: LocalDate,

  @Schema(description = "Periode til-dato")
  val periodeTil: LocalDate?,

  @Schema(description = "Angir om en inntektsopplysning er aktiv")
  val aktiv: Boolean,

  @Schema(description = "Tidspunkt inntekten tas i bruk")
  val brukFra: LocalDateTime,

  @Schema(description = "Tidspunkt inntekten ikke lenger aktiv. Null betyr at inntekten er aktiv")
  val brukTil: LocalDateTime?,

  @Schema(description = "Beløpet kontantstøtten er på")
  val belop: Int,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime
)

// PDL-data
data class EgneBarnDto(
  @Schema(description = "Id til forelderen. Kan være null ved manuelle registreringer")
  val personIdForelder: String?,

  @Schema(description = "Identen til barnet")
  var personIdBarn: String?,

  @Schema(description = "Navn på barnet, format <Fornavn, mellomnavn, Etternavn")
  var navn: String?,

  @Schema(description = "Barnets fødselsdato")
  var foedselsdato: LocalDate?,

  @Schema(description = "Barnets fødselsår")
  var foedselsaar: Int?,

  @Schema(description = "Barnets eventuelle dødsdato")
  var doedsdato: LocalDate?,

  @Schema(description = "Manuelt opprettet av")
  val opprettetAv: String?,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime,

  @Schema(description = "Perioder barnet bor i samme husstand som aktuell forelder")
  val borISammeHusstandDtoListe: List<BorISammeHusstandDto>?
)

data class BorISammeHusstandDto(
  @Schema(description = "Barnet bor i husstanden fra- og med måned")
  val periodeFra: LocalDate?,

  @Schema(description = "Barnet bor i husstanden til- og med måned")
  val periodeTil: LocalDate?,

  @Schema(description = "Manuelt opprettet av")
  val opprettetAv: String?,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime,
)

data class HusstandDto(
  @Schema(description = "Id til personen husstandsinformasjonen er rapportert for")
  val personId: String?,

  @Schema(description = "Personen (BP) bor i husstanden fra- og med måned")
  val periodeFra: LocalDate,

  @Schema(description = "Personen (BP) bor i husstanden til- og med måned")
  val periodeTil: LocalDate?,

  @Schema(description = "Navnet på en gate e.l.")
  val adressenavn: String?,

  @Schema(description = "Nummeret som identifiserer et av flere hus i en gate")
  val husnummer: String?,

  @Schema(description = "Bokstav som identifiserer del av et bygg")
  val husbokstav: String?,

  @Schema(description = "En bokstav og fire siffer som identifiserer en boligenhet innenfor et bygg eller en bygningsdel")
  val bruksenhetsnummer: String?,

  @Schema(description = "Norsk postnummer")
  val postnummer: String?,

  @Schema(description = "6 siffer, identifiserer bydel")
  val bydelsnummer: String?,

  @Schema(description = "Siffer som identifiserer hvilken kommune adressen ligger i")
  val kommunenummer: String?,

  @Schema(description = "Nøkkel til geografisk adresse registrert i Kartverkets matrikkel")
  val matrikkelId: Long?,

  @Schema(description = "Landkode, skal bare brukes for manuelt registrerte utlandsadresser")
  val landkode: String?,

  @Schema(description = "Manuelt opprettet av")
  val opprettetAv: String?,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime,

  @Schema(description = "Periodisert liste over husstandsmedlemmer")
  val husstandsmedlemmerListe: List<HusstandsmedlemDto>?
)

data class HusstandsmedlemDto(
  @Schema(description = "Husstandsmedlemmet bor i husstanden fra- og med måned")
  val periodeFra: LocalDate?,

  @Schema(description = "Husstandsmedlemmet bor i husstanden til- og med måned")
  val periodeTil: LocalDate?,

  @Schema(description = "Identen til husstandsmedlemmet")
  var personId: String?,

  @Schema(description = "Navn på husstandsmedlemmet, format <Fornavn, mellomnavn, Etternavn")
  var navn: String?,

  @Schema(description = "Husstandsmedlemmets fødselsdag")
  var foedselsdato: LocalDate?,

  @Schema(description = "Husstandsmedlemmets eventuelle dødsdato")
  var doedsdato: LocalDate?,

  @Schema(description = "Manuelt opprettet av")
  val opprettetAv: String?,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime,
)

data class SivilstandDto(
  @Schema(description = "Id til personen sivilstanden er rapportert for")
  val personId: String?,

  @Schema(description = "Sivilstand gjelder fra- og med måned")
  val periodeFra: LocalDate?,

  @Schema(description = "Sivilstand gjelder til- og med måned")
  val periodeTil: LocalDate?,

  @Schema(description = "Personens sivilstand")
  val sivilstand: SivilstandKode,

  @Schema(description = "Manuelt opprettet av")
  val opprettetAv: String?,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime,
)

data class BarnetilsynDto(

  @Schema(description = "Id til personen som mottar barnetilsynet")
  val partPersonId: String,

  @Schema(description = "Id til barnet barnetilsynet er for")
  val barnPersonId: String,

  @Schema(description = "Periode fra-dato")
  val periodeFra: LocalDate,

  @Schema(description = "Periode til-dato")
  val periodeTil: LocalDate?,

  @Schema(description = "Angir om en inntektsopplysning er aktiv")
  val aktiv: Boolean,

  @Schema(description = "Tidspunkt inntekten tas i bruk")
  val brukFra: LocalDateTime,

  @Schema(description = "Tidspunkt inntekten ikke lenger aktiv. Null betyr at inntekten er aktiv")
  val brukTil: LocalDateTime?,

  @Schema(description = "Beløpet barnetilsynet er på")
  val belop: Int,

  @Schema(description = "Angir om barnetilsynet er heltid eller deltid")
  val tilsynstype: Tilsyntype?,

  @Schema(description = "Angir om barnet er over eller under skolealder")
  val skolealder: Skolealder,

  @Schema(description = "Hentet tidspunkt")
  val hentetTidspunkt: LocalDateTime
)
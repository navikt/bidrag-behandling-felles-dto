package no.nav.bidrag.behandling.felles.dto.grunnlag

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.GrunnlagType
import no.nav.bidrag.behandling.felles.enums.GrunnlagsRequestStatus
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime



data class HentGrunnlagResponse(

  @Schema(description = "Hvilken type grunnlag som er hentet")
  val grunnlagType: GrunnlagType,

  @Schema(description = "Angir personId som grunnlag er hentet for")
  val personId: String,

  @Schema(description = "Status for utført kall")
  val status: GrunnlagsRequestStatus,

  @Schema(description = "Statusmelding for utført kall")
  val statusMelding: String,

  )


data class HentKomplettGrunnlagspakkeResponse(

  @Schema(description = "grunnlagspakke-id")
  val grunnlagspakkeId: Int,

  @Schema(description = "Liste over innhentede inntekter fra a-inntekt og underliggende poster")
  val ainntektListe: List<HentAinntektDto>,

  @Schema(description = "Liste over innhentede fra skatt og underliggende poster")
  val skattegrunnlagListe: List<HentSkattegrunnlagDto>,

  @Schema(description = "Liste over innhentet utvidet barnetrygd og småbarnstillegg")
  val ubstListe: List<HentUtvidetBarnetrygdOgSmaabarnstilleggDto>,

  @Schema(description = "Liste over innhentet barnetillegg")
  val barnetilleggListe: List<HentBarnetilleggDto>
)

@Schema(description = "Respons ved oppdatering av  grunnlagspakke")
data class OppdaterGrunnlagspakkeDto(

  @Schema(description = "Grunnlagspakke-id")
  val grunnlagspakkeId: Int = 0,

  @Schema(description = "Liste over grunnlagene som er hentet inn med person-id og status")
  val grunnlagtypeResponsListe: List<HentGrunnlagDto> = emptyList()
)


data class HentGrunnlagDto(

  @Schema(description = "Hvilken type grunnlag som er hentet")
  val grunnlagType: GrunnlagType,

  @Schema(description = "Angir personId som grunnlag er hentet for")
  val personId: String,

  @Schema(description = "Status for utført kall")
  val status: GrunnlagsRequestStatus,

  @Schema(description = "Statusmelding for utført kall")
  val statusMelding: String,

  )



data class HentAinntektDto(

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
  val ainntektspostListe: List<HentAinntektspostDto>
)


data class HentAinntektspostDto (

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


data class HentSkattegrunnlagDto(

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
  val skattegrunnlagListe: List<HentSkattegrunnlagspostDto>
)


data class HentSkattegrunnlagspostDto(

  @Schema(description = "Type skattegrunnlag, ordinær eller Svalbard")
  val skattegrunnlagType: String,

  @Schema(description = "Type inntekt, Lonnsinntekt, Naeringsinntekt, Pensjon eller trygd, Ytelse fra offentlig")
  val inntektType: String,

  @Schema(description = "Belop")
  val belop: BigDecimal
)


data class HentUtvidetBarnetrygdOgSmaabarnstilleggDto(

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
  val hentetTidspunkt: LocalDateTime
)


data class HentBarnetilleggDto(

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
  val hentetTidspunkt: LocalDateTime
)
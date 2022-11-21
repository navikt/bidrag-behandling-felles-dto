package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.StonadType
import java.math.BigDecimal
import java.time.LocalDate

@Schema(description ="Egenskaper ved en stønadsendring")
data class OpprettStonadRequestDto(

  @Schema(description = "Stønadstype")
  val stonadType: StonadType,

  @Schema(description = "Referanse til sak")
  val sakId: String,

  @Schema(description = "Id til den som skal betale bidraget")
  val skyldnerId: String,

  @Schema(description = "Id til den som krever bidraget")
  val kravhaverId: String,

  @Schema(description = "Id til den som mottar bidraget")
  val mottakerId: String,

  @Schema(description = "Angir første år en stønad skal indeksreguleres")
  val indeksreguleringAar: String?,

  @Schema(description = "Angir dato for eventuelt opphør av stønaden")
  val opphortFra: LocalDate?,

  @Schema(description = "opprettet_av")
  val opprettetAv: String,

  @Schema(description = "Liste over alle perioder som inngår i stønaden")
  val periodeListe: List<OpprettStonadPeriodeRequestDto>
)


@Schema(description ="Egenskaper ved en periode")
data class OpprettStonadPeriodeRequestDto(

  @Schema(description = "Periode fra-og-med-dato")
  val periodeFom: LocalDate,

  @Schema(description = "Periode til-dato")
  val periodeTil: LocalDate?,

  @Schema(description = "Vedtak-id")
  val vedtakId: Int,

  @Schema(description = "Periode gjort ugyldig av vedtak-id")
  val periodeGjortUgyldigAvVedtakId: Int?,

  @Schema(description = "Beregnet stønadsbeløp")
  val belop: BigDecimal,

  @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
  val valutakode: String,

  @Schema(description = "Resultatkoden tilhørende stønadsbeløpet")
  val resultatkode: String,

  )


@Schema(description ="Request for å endre mottaker-id på en stønad")
data class EndreMottakerIdRequestDto(

  @Schema(description = "Stønad-id")
  val stonadId: Int,

  @Schema(description = "Ny Mottaker-id som skal erstatte eksisterende id")
  val nyMottakerId: String,

  @Schema(description = "opprettet_av")
  val opprettetAv: String
)
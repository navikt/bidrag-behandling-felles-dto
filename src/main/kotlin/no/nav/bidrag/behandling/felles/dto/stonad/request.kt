package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

@Schema(description ="Request for å endre mottaker-id på en stønad")
data class EndreMottakerIdRequestDto(

  @Schema(description = "Stønad-id")
  val stonadId: Int,

  @Schema(description = "Ny Mottaker-id som skal erstatte eksisterende id")
  val nyMottakerId: String,

  @Schema(description = "opprettet_av")
  val opprettetAv: String
)

@Schema(description ="Egenskaper ved en periode")
data class OpprettStonadPeriodeRequestDto(

  @Schema(description = "Periode fra-og-med-dato")
  val periodeFom: LocalDate,

  @Schema(description = "Periode til-dato")
  val periodeTil: LocalDate?,

  @Schema(description = "Stonad-id")
  val stonadId: Int,

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
package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate


data class StonadPeriodeDto(

  @Schema(description = "Periode-id")
  val periodeId: Int,

  @Schema(description = "Periode fra-og-med-dato")
  val periodeFom: LocalDate,

  @Schema(description = "Periode til-dato")
  val periodeTil: LocalDate?,

  @Schema(description = "Stonad-id")
  val stonadId: Int,

  @Schema(description = "Vedtak-id")
  val vedtakId: Int,

  @Schema(description = "Periode-gjort-ugyldig-av-vedtak-id")
  val periodeGjortUgyldigAvVedtakId: Int?,

  @Schema(description = "Beregnet stønadsbeløp")
  val belop: BigDecimal,

  @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
  val valutakode: String,

  @Schema(description = "Resultatkode for stønaden")
  val resultatkode: String
)
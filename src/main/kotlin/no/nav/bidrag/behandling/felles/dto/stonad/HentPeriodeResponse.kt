package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigDecimal
import java.time.LocalDate

data class HentPeriodeResponse(

  @Schema(description = "Periode-id")
  val periodeId: Int = 0,

  @Schema(description = "Periode fra-og-med-dato")
  val periodeFom: LocalDate = LocalDate.now(),

  @Schema(description = "Periode til-dato")
  val periodeTil: LocalDate? = null,

  @Schema(description = "Stonad-id")
  val stonadId: Int = 0,

  @Schema(description = "Vedtak-id")
  val vedtakId: Int = 0,

  @Schema(description = "Periode-gjort-ugyldig-av-vedtak-id")
  val periodeGjortUgyldigAvVedtakId: Int? = 0,

  @Schema(description = "Beregnet stønadsbeløp")
  val belop: BigDecimal = BigDecimal.ZERO,

  @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
  val valutakode: String = "NOK",

  @Schema(description = "Resultatkode for stønaden")
  val resultatkode: String = ""
)
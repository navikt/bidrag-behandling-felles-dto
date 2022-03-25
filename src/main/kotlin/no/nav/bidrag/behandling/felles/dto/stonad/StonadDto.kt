package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.StonadType
import java.time.LocalDateTime

data class StonadDto(
  @Schema(description = "StønadId")
  val stonadId: Int,

  @Schema(description = "Stønadstype")
  val stonadType: StonadType,

  @Schema(description = "Referanse til sak")
  val sakId: String?,

  @Schema(description = "Id til den som skal betale bidraget")
  val skyldnerId: String,

  @Schema(description = "Id til den som krever bidraget")
  val kravhaverId: String,

  @Schema(description = "Id til den som mottar bidraget")
  val mottakerId: String,

  @Schema(description = "opprettet_av")
  val opprettetAv: String,

  @Schema(description = "opprettet_timestamp")
  val opprettetTimestamp: LocalDateTime,

  @Schema(description = "endret_av")
  val endretAv: String?,

  @Schema(description = "når_sist_endret_timestamp")
  val endretTimestamp: LocalDateTime?,

  @Schema(description = "Liste over alle perioder som inngår i stønaden")
  val periodeListe: List<StonadPeriodeDto>
)
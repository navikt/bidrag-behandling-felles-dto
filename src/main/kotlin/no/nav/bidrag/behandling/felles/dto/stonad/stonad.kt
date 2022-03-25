package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.StonadType
import java.time.LocalDateTime

interface StonadService {
  fun hentStonad(stonadId: Int): StonadDto

  fun endreMottakerIdOgOpprettHistorikk(request: EndreMottakerIdRequestDto): MottakerIdHistorikkDto
}


data class StonadDto(
  @Schema(description = "StønadId")
  val stonadId: Int = 0,

  @Schema(description = "Stønadstype")
  val stonadType: StonadType,

  @Schema(description = "Referanse til sak")
  val sakId: String? = null,

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
  val endretAv: String? = null,

  @Schema(description = "når_sist_endret_timestamp")
  val endretTimestamp: LocalDateTime? = null,

  @Schema(description = "Liste over alle perioder som inngår i stønaden")
  val periodeListe: List<PeriodeDto>
)

data class EndreMottakerIdDto(
  @Schema(description = "stonad-id")
  val stonadId: Int = 0,

  @Schema(description = "Utgått Mottaker-Id")
  val mottakerIdEndretFra: String = "",

  @Schema(description = "Ny Mottaker-Id")
  val mottakerIdEndretTil: String = "",

  @Schema(description = "Saksbehandler/batchjobb/annet som har oppdatert mottaker-id")
  val opprettetAv: String = "",

  @Schema(description = "Opprettet timestamp")
  val opprettetTimestamp: LocalDateTime = LocalDateTime.now()
)

@Schema(description ="Request for å endre mottaker-id på en stønad")
data class EndreMottakerIdRequestDto(

  @Schema(description = "Stønad-id")
  val stonadId: Int,

  @Schema(description = "Ny Mottaker-id som skal erstatte eksisterende id")
  val nyMottakerId: String,

  @Schema(description = "opprettet_av")
  val opprettetAv: String = ""
)
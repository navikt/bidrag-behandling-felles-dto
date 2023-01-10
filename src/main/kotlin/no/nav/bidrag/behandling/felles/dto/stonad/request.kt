package no.nav.bidrag.behandling.felles.dto.stonad

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.Innkreving
import no.nav.bidrag.behandling.felles.enums.StonadType
import java.math.BigDecimal
import java.time.LocalDate

@Schema(description ="Egenskaper ved en stønadsendring")
data class OpprettStonadRequestDto(

  @Schema(description = "Stønadstype")
  val type: StonadType,

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

  @Schema(description = "Angir om stønaden skal innkreves")
  val innkreving: Innkreving,

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
  val belop: BigDecimal?,

  @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
  val valutakode: String?,

  @Schema(description = "Resultatkoden tilhørende stønadsbeløpet")
  val resultatkode: String,

  )


@Schema(description ="Request for å hente stønad som matcher angitte parametre")
data class HentStonadRequest(
  @Schema(description = "Stønadstype")
  val type: StonadType,

  @Schema(description = "Referanse til sak")
  val sakId: String,

  @Schema(description = "Id til den som skal betale stønadem")
  val skyldnerId: String,

  @Schema(description = "Id til den som krever stønadem")
  val kravhaverId: String,
)
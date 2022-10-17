package no.nav.bidrag.behandling.felles.dto.vedtak

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.EngangsbelopType
import no.nav.bidrag.behandling.felles.enums.GrunnlagType
import no.nav.bidrag.behandling.felles.enums.StonadType
import no.nav.bidrag.behandling.felles.enums.VedtakType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

@Schema
data class VedtakDto(

  @Schema(description = "Vedtak-id")
  var vedtakId: Int,

  @Schema(description = "Vedtak-type")
  var vedtakType: VedtakType,

  @Schema(description = "Id til saksbehandler/batchjobb evt annet som opprettet vedtaket")
  var opprettetAv: String,

  @Schema(description = "Dato vedtaket er fattet")
  val vedtakDato: LocalDate?,

  @Schema(description = "Id til enheten som er ansvarlig for vedtaket")
  var enhetId: String,

  @Schema(description = "Opprettet timestamp")
  var opprettetTimestamp: LocalDateTime,

  @Schema(description = "Liste over alle grunnlag som inngår i vedtaket")
  var grunnlagListe: List<GrunnlagDto>,

  @Schema(description = "Liste over alle stønadsendringer som inngår i vedtaket")
  var stonadsendringListe: List<StonadsendringDto>,

  @Schema(description = "Liste over alle engangsbeløp som inngår i vedtaket")
  var engangsbelopListe: List<EngangsbelopDto>,

  @Schema(description = "Liste med referanser til alle behandlinger som ligger som grunnlag til vedtaket")
  val behandlingsreferanseListe: List<BehandlingsreferanseDto>
)


@Schema
data class GrunnlagDto(

  @Schema(description = "Grunnlag-id")
  val grunnlagId: Int,

  @Schema(description = "Referanse til grunnlaget")
  val referanse: String,

  @Schema(description = "Grunnlagstype")
  val type: GrunnlagType,

  @Schema(description = "Innholdet i grunnlaget")
  val innhold: JsonNode
)

@Schema
data class StonadsendringDto(

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

  @Schema(description = "Liste over alle perioder som inngår i stønadsendringen")
  val periodeListe: List<VedtakPeriodeDto>
)


@Schema
data class EngangsbelopDto(

  @Schema(description =  "Id for engangsbeløpet, må returneres for å kunne endres senere")
  val engangsbelopId: Int,

  @Schema(description = "Løpenr innenfor vedtak")
  val lopenr: Int,

  @Schema(description =  "Id for eventuelt engangsbeløp som skal endres")
  val endrerEngangsbelopId: Int?,

  @Schema(description =  "Type Engangsbeløp. Saertilskudd, gebyr m.m.")
  val type: EngangsbelopType,

  @Schema(description = "Referanse til sak")
  val sakId: String?,

  @Schema(description =  "Id til den som skal betale engangsbeløpet")
  val skyldnerId: String,

  @Schema(description =  "Id til den som krever engangsbeløpet")
  val kravhaverId: String,

  @Schema(description =  "Id til den som mottar engangsbeløpet")
  val mottakerId: String,

  @Schema(description =  "Beregnet engangsbeløp")
  val belop: BigDecimal,

  @Schema(description =  "Valutakoden tilhørende engangsbeløpet")
  val valutakode: String,

  @Schema(description =  "Resultatkoden tilhørende engangsbeløpet")
  val resultatkode: String,

  @Schema(description = "Referanse - beslutningslinjeId -> bidrag-regnskap")
  val referanse: String?,

  @Schema(description =  "Liste over alle grunnlag som inngår i beregningen")
  val grunnlagReferanseListe: List<String>
)


@Schema
data class BehandlingsreferanseDto(

  @Schema(description ="Kildesystem for behandlingen før vedtaket")
  val kilde: String,

  @Schema(description = "Kildesystemets referanse til behandlingen")
  val referanse: String
)


@Schema
data class VedtakPeriodeDto(

  @Schema(description = "Periode fra-og-med-dato")
  val periodeFomDato: LocalDate,

  @Schema(description = "Periode til-dato")
  val periodeTilDato: LocalDate?,

  @Schema(description = "Beregnet stønadsbeløp")
  val belop: BigDecimal,

  @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
  val valutakode: String,

  @Schema(description = "Resultatkoden tilhørende  stønadsbeløpet")
  val resultatkode: String,

  @Schema(description = "Referanse - beslutningslinjeId -> bidrag-regnskap")
  val referanse: String?,

  @Schema(description = "Liste over alle grunnlag som inngår i perioden")
  val grunnlagReferanseListe: List<String>
)
package no.nav.bidrag.behandling.felles.dto.vedtak

import com.fasterxml.jackson.databind.JsonNode
import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.EngangsbelopType
import no.nav.bidrag.behandling.felles.enums.GrunnlagType
import no.nav.bidrag.behandling.felles.enums.StonadType
import no.nav.bidrag.behandling.felles.enums.VedtakType
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Schema
data class OpprettVedtakRequestDto(

  @Schema(description = "Hva slags type vedtak som er fattet")
  val vedtakType: VedtakType,

  @Schema(description = "Id til saksbehandler/batchjobb evt. annet som oppretter vedtaket")
  @Size(min = 5)
  val opprettetAv: String,

  @Schema(description = "Dato vedtaket er fattet")
  val vedtakDato: LocalDate,

  @Schema(description = "Id til enheten som er ansvarlig for vedtaket")
  @NotBlank
  val enhetId: String,

  @Schema(description = "Referanse som brukes i utlandssaker")
  val eksternReferanse: String?,

  @Schema(description = "Settes hvis overføring til Elin skal utsettes")
  val utsattTilDato: LocalDate?,

  @Schema(description = "Liste over alle grunnlag som inngår i vedtaket")
  @field:Valid
  val grunnlagListe: List<OpprettGrunnlagRequestDto>,

  @Schema(description = "Liste over alle stønadsendringer som inngår i vedtaket")
  @field:Valid
  val stonadsendringListe: List<OpprettStonadsendringRequestDto>?,

  @Schema(description = "Liste over alle engangsbeløp som inngår i vedtaket")
  @field:Valid
  val engangsbelopListe: List<OpprettEngangsbelopRequestDto>?,

  @Schema(description = "Liste med referanser til alle behandlinger som ligger som grunnlag til vedtaket")
  @field:Valid
  val behandlingsreferanseListe: List<OpprettBehandlingsreferanseRequestDto>?
)


@Schema
data class OpprettGrunnlagRequestDto(

  @Schema(description = "Referanse til grunnlaget")
  @NotBlank
  val referanse: String,

  @Schema(description = "Grunnlagstype")
  @NotBlank
  val type: GrunnlagType,

  @Schema(description = "Innholdet i grunnlaget")
  @NotBlank
  val innhold: JsonNode
)


@Schema
data class OpprettStonadsendringRequestDto(

  @Schema(description = "Stønadstype")
  @NotBlank
  val stonadType: StonadType,

  @Schema(description = "Referanse til sak")
  val sakId: String,

  @Schema(description = "Id til den som skal betale bidraget")
  @field:Pattern(
    regexp = "^[0-9]{9}$|^[0-9]{11}$",
    message = "Ugyldig format. Må inneholde eksakt 9 eller 11 siffer."
  )
  val skyldnerId: String,

  @Schema(description = "Id til den som krever bidraget")
  @field:Pattern(
    regexp = "^[0-9]{9}$|^[0-9]{11}$",
    message = "Ugyldig format. Må inneholde eksakt 9 eller 11 siffer."
  )
  val kravhaverId: String,

  @Schema(description = "Id til den som mottar bidraget")
  @field:Pattern(
    regexp = "^[0-9]{9}$|^[0-9]{11}$",
    message = "Ugyldig format. Må inneholde eksakt 9 eller 11 siffer."
  )
  val mottakerId: String,

  @Schema(description = "Liste over alle perioder som inngår i stønadsendringen")
  @field:Valid
  @field:NotEmpty(message = "Listen kan ikke være null eller tom.")
  val periodeListe: List<OpprettVedtakPeriodeRequestDto>
)


@Schema
data class OpprettEngangsbelopRequestDto(

  @Schema(description ="Id for eventuelt engangsbeløp som skal endres, skal være id for opprinnelig engangsbeløp")
  val endrerEngangsbelopId: Int?,

  @Schema(description ="Beløpstype. Saertilskudd, gebyr m.m.")
  @NotBlank
  val type: EngangsbelopType,

  @Schema(description = "Referanse til sak")
  val sakId: String,

  @Schema(description ="Id til den som skal betale engangsbeløpet")
  @field:Pattern(regexp = "^[0-9]{9}$|^[0-9]{11}$", message = "Ugyldig format. Må inneholde eksakt 9 eller 11 siffer.")
  val skyldnerId: String,

  @Schema(description ="Id til den som krever engangsbeløpet")
  @field:Pattern(regexp = "^[0-9]{9}$|^[0-9]{11}$", message = "Ugyldig format. Må inneholde eksakt 9 eller 11 siffer.")
  val kravhaverId: String,

  @Schema(description ="Id til den som mottar engangsbeløpet")
  @field:Pattern(regexp = "^[0-9]{9}$|^[0-9]{11}$", message = "Ugyldig format. Må inneholde eksakt 9 eller 11 siffer.")
  val mottakerId: String,

  @Schema(description ="Beregnet engangsbeløp")
  @Min(0)
  val belop: BigDecimal,

  @Schema(description ="Valutakoden tilhørende engangsbeløpet")
  @NotBlank
  val valutakode: String,

  @Schema(description ="Resultatkoden tilhørende engangsbeløpet")
  @NotBlank
  val resultatkode: String,

  @Schema(description = "Referanse - beslutningslinjeId -> bidrag-regnskap")
  val referanse: String?,

  @Schema(description ="Liste over alle grunnlag som inngår i engangsbeløpet")
  @NotEmpty
  val grunnlagReferanseListe: List<String>
)


@Schema
data class OpprettBehandlingsreferanseRequestDto(

  @Schema(description ="Kildesystem for behandlingen før vedtaket")
  @NotBlank
  val kilde: String,

  @Schema(description = "Kildesystemets referanse til behandlingen")
  @NotBlank
  val referanse: String
)


@Schema
data class OpprettVedtakPeriodeRequestDto(

  @Schema(description = "Periode fra-og-med-dato")
  val periodeFomDato: LocalDate,

  @Schema(description = "Periode til-dato")
  val periodeTilDato: LocalDate?,

  @Schema(description = "Beregnet stønadsbeløp")
  @Min(0)
  val belop: BigDecimal,

  @Schema(description = "Valutakoden tilhørende stønadsbeløpet")
  @NotBlank
  val valutakode: String,

  @Schema(description = "Resultatkoden tilhørende stønadsbeløpet")
  @NotBlank
  val resultatkode: String,

  @Schema(description = "Referanse - beslutningslinjeId -> bidrag-regnskap")
  val referanse: String?,

  @Schema(description = "Liste over alle grunnlag som inngår i perioden")
  @NotEmpty
  val grunnlagReferanseListe: List<String>
)


@Schema
data class OpprettVedtakPeriodeGrunnlagRequestDto(

  @Schema(description = "Periode-id")
  @Min(0)
  val periodeId: Int,

  @Schema(description = "grunnlag-id")
  @Min(0)
  val grunnlagId: Int
)
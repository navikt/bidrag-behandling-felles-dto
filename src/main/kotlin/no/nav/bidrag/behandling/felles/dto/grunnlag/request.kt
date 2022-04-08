package no.nav.bidrag.behandling.felles.dto.grunnlag

import io.swagger.v3.oas.annotations.media.Schema
import no.nav.bidrag.behandling.felles.enums.Formaal
import no.nav.bidrag.behandling.felles.enums.GrunnlagType
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Pattern


@Schema(description ="Request for å opprette ny grunnlagspakke, uten annet innhold")
data class OpprettGrunnlagspakkeRequestDto (

  @Schema(description = "Til hvilket formål skal grunnlagspakken benyttes. BIDRAG, FORSKUDD eller SAERTILSKUDD")
  val formaal: Formaal,

  @Schema(description = "opprettet av")
  @field:NotBlank(message = "Kan ikke være null eller blank.")
  val opprettetAv: String
)


data class OppdaterGrunnlagspakkeRequestDto(

  @Schema(description = "Opplysningene som hentes er gyldige til (men ikke med) denne datoen (YYYY-MM-DD")
  val gyldigTil: LocalDate? = null,

  @Schema(description = "Liste over hvilke typer grunnlag som skal hentes inn. På nivået under er personId og perioder angitt")
  @field:Valid
  @field:NotEmpty(message = "Listen kan ikke være null eller tom.")
  val grunnlagRequestDtoListe: List<GrunnlagRequestDto>
)


data class GrunnlagRequestDto(

  @Schema(description = "Hvilken type grunnlag skal hentes")
  val grunnlagType: GrunnlagType,

  @Schema(description = "Angir personId som grunnlag skal hentes for")
  @field:Pattern(regexp = "^[0-9]{11}\$", message = "Ugyldig format. Må inneholde eksakt 11 siffer.")
  val personId: String,

  @Schema(description = "Første periode det skal hentes ut grunnlag for (på formatet YYYY-MM-DD)")
  val periodeFra: LocalDate,

  @Schema(description = "Grunnlag skal hentes TIL denne perioden, på formatet YYYY-MM-DD")
  val periodeTil: LocalDate,

  @Schema(description = "Hent historiske inntekter fra Inntektskomponenten på angitt dato, skal kun brukes til engangsinnhenting av historikk")
  val innsynHistoriskeInntekterDato: LocalDate? = null
)
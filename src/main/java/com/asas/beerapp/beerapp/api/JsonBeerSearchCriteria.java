package com.asas.beerapp.beerapp.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@ApiModel
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonBeerSearchCriteria {

    // TODO test with no value. No value should be allowed
    @ApiModelProperty(
            value = "IBU greater than",
            dataType = "String",
            example = "20")
    @Min(5)
    private int ibuGt;

    @ApiModelProperty(
            value = "IBU less than",
            dataType = "String",
            example = "80")
    @Max(120)
    private int ibuLt;

    @ApiModelProperty(
            value = "the yeast used for fermentation",
            dataType = "String",
            example = "American Ale")
    private String yeast;

    @ApiModelProperty(
            value = "food these beers are pairing with",
            dataType = "String",
            example = "spicy beef")
    private String food;
}

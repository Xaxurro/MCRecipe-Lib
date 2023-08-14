package org.xaxurro.classes.recipe.properties;

import lombok.*;
import org.json.JSONObject;
import org.xaxurro.classes.utils.IdUtils;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class MCResult {
    String id;
    int count = 1;

    public MCResult(String resultId) {
        IdUtils.isValidThrow(resultId);
        this.id = IdUtils.parse(resultId);
    }
    public MCResult(String resultId, int count) {
        IdUtils.isValidThrow(resultId);
        this.id = IdUtils.parse(resultId);
        this.count = count;
    }

    public static MCResult buildFromJSON(JSONObject jsonObject) {
        int count = jsonObject.optInt("count", 1);
        return new MCResult(jsonObject.getString("item"), count);
    }
}

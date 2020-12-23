

//Assume large JSON responses are being returned, How will you find the max depth of this response JSON in best possible way with using optimal
// resources? Assume your application may not have enough memory to load these complete JSON into memory due to memory constraint.

// Approaches:
// 1. JSONObject Class --> This class has constructor to parse the string which converts into JSON object. Now simply traverse this object to find the depth. This
//....solution will fail as it does not cater to memory constraints.
// 2. Traverse the Json character by character and increment depth count by one whenever you encounter opening brace. Since this JSON may not fit in memory, even if we assume that some responses
//.... don't fit into memory, but still it will be dangerous to flatten deeply nested JSON objects recursively  their are limits to the depth of stack as they could result in stack overflow errors.
// 3.

//https://jsfiddle.net/95g3ebp7/
public class FindDepthOfSONObject {
    public static void main(String[] args) {

    }
}

// package com.aryan.ecom.dto;





// import jakarta.validation.Valid;
// import jakarta.validation.constraints.Email;

// import jakarta.validation.constraints.NotNull;
// import lombok.Data;
// @Valid
// @Data
// public class SignupRequest {
//     @NotNull
//     @Email(message = "Invalid email format")
// 	private String email;
// 	@NotNull(message = "Name cannot be blank")
// 	private String name;
// 	private String password;
// }
package com.aryan.ecom.dto;





import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class SignupRequest {
    
    @NotEmpty(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    private String email;
    
    @NotEmpty(message = "Name cannot be null")
    private String name;
    
    private String password;
}

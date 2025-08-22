package ProyectoModulo_AngelRivera_20230272.AngelRivera_20230272.Models.ApiResponse;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiResponse<T>{
        private boolean success;
        private String message;
        private T data;

        public ApiResponse(boolean success, String message, T data) {
            this.success = success;
            this.message = message;
            this.data = data;
        }

        public static <T> ApiResponse<T> success(T data) {
            return new ApiResponse<>(true, "Operación exitosa", data);
        }

        public static <T> ApiResponse<T> success(String message, T data) {
            return new ApiResponse<>(true, message, data);
        }

        public static ApiResponse<?> error(String message) {
            return new ApiResponse<>(false, message, null);
        }
    }


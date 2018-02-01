package Week1HW.q15;

/**
 * Functionality: Implements MathInterface and provides additional functionality.
 */
public class MathImplementation implements MathInterface {
    @Override
    public float add(float... params) {
        float result = 0;
        for (float f:params //adds all parameters together
             ) {
            result += f;
        }
        return result;
    }

    @Override
    public float subtract(float... params) {//first parameter is subtracted by all other parameters
        float result = params[0];
        params[0] = 0;
        for (float f:params
                ) {
            result -= f;
        }
        return result;
    }

    @Override
    public float multiply(float... params) {//all parameters are multiplied together
        float result = 1;
        for (float f:params
                ) {
            result *= f;
        }
        return result;
    }

    @Override
    public float divide(float... params) {//first parameter is divided by all other parameters
        float result = params[0];
        params[0] = 1;
        for (float f:params
                ) {
            result /= f;
        }
        return result;
    }
}

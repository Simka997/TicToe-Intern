package com.interw.interfaces;

import com.interw.еxceptions.PositionNotValidException;
// for next AI impl
public interface InputValidatorInterface {
    void getCordinatesFronUserInput(String position) throws PositionNotValidException;
    boolean isSpaceBetweenXandY(String position);
}


import cm.CarParkKind;
import cm.CarParkStatus;
import cm.Period;
import cm.Rate;

import java.math.BigDecimal;
import java.util.ArrayList;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class WojnowskiMichalTestTask3 {

    @Test
    public void successPassTest() {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 18);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overlapping() {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period a = new Period(0, 8);
        Period b = new Period(9, 12);
        Period c = new Period(11, 13);
        Period d = new Period(14, 23);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(a);
        normalP.add(b);
        reducedP.add(c);
        reducedP.add(d);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullNormalRate() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = null;
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 18);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPeriods() {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 18);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(null);
        reducedP.add(null);

        Rate rate = new Rate(kind, normal, reduced, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullReducedRate() {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(1);
        BigDecimal reduced = null;
        Period periodN = new Period(7, 18);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = NullPointerException.class)
    public void nullNormalPerdio() {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = null;
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rateTets = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = NullPointerException.class)
    public void nullReducedPeriod() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 18);
        Period periodR = null;
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overlappingTimesInNP() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(5,10);
        Period periodN2 = new Period(7, 18);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        normalP.add(periodN2);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void overlappingTimesInRP() {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 18);
        Period periodR = new Period(19, 21);
        Period periodR2 = new Period(20, 6);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);
        reducedP.add(periodR2);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test
    public void nPOverlappingRP() {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 18);
        Period periodR = new Period(18, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test
    public void rPOverlappingNP() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 19);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nRLessThanRR() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = new BigDecimal(0);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 19);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test
    public void rRIs0() {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(0);
        Period periodN = new Period(7, 18);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeRR() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(-1);
        Period periodN = new Period(7, 19);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNR() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = new BigDecimal(-1);
        BigDecimal reduced = new BigDecimal(0);
        Period periodN = new Period(7, 19);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nRAndRR0() {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(0);
        BigDecimal reduced = new BigDecimal(0);
        Period periodN = new Period(7, 19);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nrAndRRNegative() {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(-1);
        BigDecimal reduced = new BigDecimal(-1);
        Period periodN = new Period(7, 19);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
    }

    @Test
    public void normalPeriodStay() {
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 19);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period stayPeriod = new Period(7, 15);
        assertEquals(rate.calculate(stayPeriod), new BigDecimal(16));
    }

    @Test
    public void reducedPeriodStay() {
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 19);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period stayPeriod = new Period(20, 21);
        assertEquals(rate.calculate(stayPeriod), new BigDecimal(1));
    }

    @Test
    public void normalToReducedPeriodStay() {
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(7, 19);
        Period periodR = new Period(19, 21);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period stayPeriod = new Period(17, 21);
        assertEquals(rate.calculate(stayPeriod), new BigDecimal(6));
    }

    @Test
    public void normalToFreePeriodStay() {
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normal = new BigDecimal(2);
        BigDecimal reduced = new BigDecimal(1);
        Period periodN = new Period(10, 21);
        Period periodR = new Period(0, 9);
        ArrayList<Period> normalP = new ArrayList<Period>();
        ArrayList<Period> reducedP = new ArrayList<Period>();
        normalP.add(periodN);
        reducedP.add(periodR);

        Rate rate = new Rate(kind, normal, reduced, reducedP, normalP);
        Period stayPeriod = new Period(19, 23);
        assertEquals(rate.calculate(stayPeriod), new BigDecimal(4));
    }


}
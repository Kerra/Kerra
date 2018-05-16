package testsrc.adderNetwork;

import kerra.neural.learning.*;

public class Population extends GenerationalPopulation {

    @Override
    protected void evolve() {
        Individual[] newGen = new Individual[size()];
        double code1[], code2[], newCode[];
        Individual parents[];

        for (int i=0; i<size(); i++) {
            parents = ParentSelection.stochasticUniversalSampling(population);
            code1 = Encoder.encode(parents[0].getWeights());
            code2 = Encoder.encode(parents[1].getWeights());
            newCode = Crossover.uniform(code1, code2);

            Mutation.reset(newCode, 0, Math.nextUp(1.0));
            newGen[i] = new Individual(Decoder.decode(newCode, parents[0].getWeights()));
        }

        setPopulation(newGen);
    }
}

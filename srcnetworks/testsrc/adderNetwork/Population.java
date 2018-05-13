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
            newCode = Crossover.multiPoint(code1, code2);

            Mutation.mutate(newCode, 0.001);
            newGen[i] = new Individual(Decoder.decode(newCode, parents[0].getWeights()));
        }

        setPopulation(newGen);
    }
}

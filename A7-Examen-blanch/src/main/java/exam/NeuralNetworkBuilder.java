package exam;

import exam.activation.ActivationFunction;
import exam.layer.HiddenLayer;
import exam.layer.InputLayer;
import exam.layer.Layer;
import exam.layer.OutputLayer;

import java.util.ArrayList;
import java.util.List;

public class NeuralNetworkBuilder {
    private final NeuralNetwork network;
    private final List<Layer> layers = new ArrayList<>();
    private boolean hasInput = false;
    private boolean hasOutput = false;
    private boolean built = false;

    public NeuralNetworkBuilder() {
        this(new NeuralNetwork());
    }

    public NeuralNetworkBuilder(NeuralNetwork network) {
        this.network = network;
    }

    public NeuralNetworkBuilder inputLayer(int size) {
        if (hasInput) {
            throw new IllegalStateException("La couche d'entrée est déjà définie");
        }
        layers.add(new InputLayer(size));
        hasInput = true;
        return this;
    }

    public NeuralNetworkBuilder hiddenLayer(int size, ActivationFunction activation) {
        return hiddenLayer(new HiddenLayer(size, activation));
    }

    // Accepte une couche déjà créée, par exemple une couche décorée (Decorator)
    public NeuralNetworkBuilder hiddenLayer(Layer layer) {
        if (!hasInput) {
            throw new IllegalStateException("Il faut d'abord définir la couche d'entrée");
        }
        if (hasOutput) {
            throw new IllegalStateException("Impossible d'ajouter une couche cachée après la couche de sortie");
        }
        layers.add(layer);
        return this;
    }

    public NeuralNetworkBuilder outputLayer(int size, ActivationFunction activation) {
        if (!hasInput) {
            throw new IllegalStateException("Il faut d'abord définir la couche d'entrée");
        }
        if (hasOutput) {
            throw new IllegalStateException("La couche de sortie est déjà définie");
        }
        layers.add(new OutputLayer(size, activation));
        hasOutput = true;
        return this;
    }

    public NeuralNetwork build() {
        if (built) {
            throw new IllegalStateException("Ce builder a déjà construit un réseau");
        }
        if (!hasInput || !hasOutput) {
            throw new IllegalStateException("Un réseau doit avoir une couche d'entrée et une couche de sortie");
        }
        for (Layer layer : layers) {
            network.addLayer(layer);
        }
        built = true;
        return network;
    }
}
package nicoLang.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import nicoLang.FinalState;
import nicoLang.aspects.StateAspect;

@Aspect(className = FinalState.class)
@SuppressWarnings("all")
public class FinalStateAspect extends StateAspect {
}

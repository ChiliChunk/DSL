package nicoLang.aspects;

import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import nicoLang.InitState;
import nicoLang.aspects.StateAspect;

@Aspect(className = InitState.class)
@SuppressWarnings("all")
public class InitStateAspect extends StateAspect {
}

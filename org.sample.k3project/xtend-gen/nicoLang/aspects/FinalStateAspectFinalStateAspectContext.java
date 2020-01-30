package nicoLang.aspects;

import java.util.Map;
import nicoLang.FinalState;
import nicoLang.aspects.FinalStateAspectFinalStateAspectProperties;

@SuppressWarnings("all")
public class FinalStateAspectFinalStateAspectContext {
  public final static FinalStateAspectFinalStateAspectContext INSTANCE = new FinalStateAspectFinalStateAspectContext();
  
  public static FinalStateAspectFinalStateAspectProperties getSelf(final FinalState _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new nicoLang.aspects.FinalStateAspectFinalStateAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<FinalState, FinalStateAspectFinalStateAspectProperties> map = new java.util.WeakHashMap<nicoLang.FinalState, nicoLang.aspects.FinalStateAspectFinalStateAspectProperties>();
  
  public Map<FinalState, FinalStateAspectFinalStateAspectProperties> getMap() {
    return map;
  }
}

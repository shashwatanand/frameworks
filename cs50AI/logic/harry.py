from logic import *

rain = Symbol("rain")  # It is raining
hagrid = Symbol("hagrid")  # Harry visited Hagrid
dumbledore = Symbol("dumbledore")  # Harry visited Dumbledore

sentence = And(rain, hagrid)
print(sentence.formula())

kownledge = And(
    Implication(Not(rain), hagrid),
    Or(hagrid, dumbledore),
    Not(And(hagrid, dumbledore)),
    dumbledore
)

print(kownledge.formula())

/*
 * Copyright (c) 2011-2017 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package reactor.core.publisher;

/**
 * Blocks until the upstream signals its last value or completes.
 *
 * @param <T> the value type
 * @see <a href="https://github.com/reactor/reactive-streams-commons">https://github.com/reactor/reactive-streams-commons</a>
 */
/*
 * The following comment is a operator codification meant to be searchable.
 * See https://github.com/reactor/reactor-core/issues/1673 for a
 * complete description of each element codified and the associated values.
 *
 * {GEOMETRY}: SUBSCRIBER
 * {OTHER}: blocking
 */
final class BlockingLastSubscriber<T> extends BlockingSingleSubscriber<T> {

	@Override
	public void onNext(T t) {
		value = t;
	}

	@Override
	public void onError(Throwable t) {
		value = null;
		error = t;
		countDown();
	}
}
